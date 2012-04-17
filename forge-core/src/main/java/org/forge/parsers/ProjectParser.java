package org.forge.parsers;

import org.forge.exceptions.MandatoryParameterException;
import org.forge.modele.Project;
import org.forge.modele.ProjectDefinition;
import org.parboiled.BaseParser;
import org.parboiled.Rule;
import org.parboiled.annotations.BuildParseTree;

import java.util.StringTokenizer;

@BuildParseTree
public class ProjectParser extends BaseParser<Object> {

    Rule Project() {
        return Sequence(
                ProjectDefinition(),
                ZeroOrMore(
                        FirstOf(
                                Dependencies(),
                                Repositories()
                        )
                )
        );
    }

    Rule ProjectDefinition() {
        return null;
    }

    Rule Repositories() {
        return Sequence(
                "repositories",'{',
                OneOrMore(Repository()),
                '}'
        );
    }

    Rule Dependencies() {
        return Sequence(
                "dependencies",'{',
                OneOrMore(
                        FirstOf(Dependency(),
                                GroupDependencies()
                        )
                ),
                '}'
        );
    }

    Rule Dependency() {
        return Sequence(
                GroupId(),
                ':',
                ArtifactId(),
                ':',
                Version(),
                ZeroOrMore(',')
        );
    }

    Rule GroupDependencies() {
        return Sequence(
                GroupId(),
                ':',
                ':',
                Version(),
                '{',
                OneOrMore(ArtifactDependency()),
                '}'
        );
    }

    Rule ArtifactDependency() {
        return Sequence(
                ArtifactId(),
                ','
        );
    }

    Rule GroupId() {
        return OneOrMore(FirstOf(CharRange('a', 'z'), CharRange('A', 'Z'), '.', '-'));
    }

    Rule ArtifactId() {
        return OneOrMore(FirstOf(CharRange('a', 'z'), CharRange('A', 'Z'), '.', '-'));
    }

    Rule Version() {
        return OneOrMore(FirstOf(CharRange('0', '9'), CharRange('a', 'z'), CharRange('A', 'Z'), '.'));
    }

    Rule Repository() {
        return Sequence(
                Id(),':',Url()
        );
    }

    Rule Id() {
        return OneOrMore(FirstOf(CharRange('a', 'z'), CharRange('A', 'Z')));
    }

    Rule Url() {
        return OneOrMore(FirstOf(CharRange('a', 'z'), CharRange('A', 'Z'), ':', '/', '.'));
    }
}
