package org.forge.parsers;

import org.forge.exceptions.MandatoryParameterException;
import org.forge.modele.Project;
import org.forge.modele.ProjectDefinition;
import org.parboiled.BaseParser;
import org.parboiled.Context;
import org.parboiled.Parboiled;
import org.parboiled.Rule;
import org.parboiled.annotations.BuildParseTree;

import java.util.StringTokenizer;

@BuildParseTree
public class ProjectParser extends BaseParser<Object> {

    private DependenciesParser dependenciesParser = Parboiled.createParser(DependenciesParser.class);
    private RepositoriesParser repositoriesParser = Parboiled.createParser(RepositoriesParser.class);


    @Override
    public void setContext(Context<Object> context) {
        dependenciesParser.setContext(context);
        repositoriesParser.setContext(context);
        super.setContext(context);
    }

    Rule Project() {
        return Sequence(
                ProjectDefinition(),
                ZeroOrMore(
                        FirstOf(
                                dependenciesParser.Dependencies(),
                                repositoriesParser.Repositories()
                        )
                )
        );
    }

    Rule ProjectDefinition() {
        return null;
    }

}
