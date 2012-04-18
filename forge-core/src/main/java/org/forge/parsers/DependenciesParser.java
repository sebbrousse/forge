package org.forge.parsers;

import org.parboiled.BaseParser;
import org.parboiled.Rule;
import org.parboiled.annotations.BuildParseTree;

/**
 * Created with IntelliJ IDEA.
 * User: sebastien
 * Date: 17/04/12
 * Time: 15:43
 */
@BuildParseTree
public class DependenciesParser extends BaseParser<Object> {

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

}