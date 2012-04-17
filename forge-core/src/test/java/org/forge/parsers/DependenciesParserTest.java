package org.forge.parsers;

import org.junit.Before;
import org.junit.Test;
import org.parboiled.Parboiled;
import org.parboiled.common.StringUtils;
import org.parboiled.parserunners.RecoveringParseRunner;
import org.parboiled.support.ParseTreeUtils;
import org.parboiled.support.ParsingResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.forge.Builders.aDependency;
import static org.forge.Builders.aGroupOfDependency;
import static org.forge.Builders.aProject;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: sebastien
 * Date: 17/04/12
 * Time: 16:01
 */
public class DependenciesParserTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(DependenciesParserTest.class);

    private ProjectParser parser;

    @Before
    public void init() {
        parser = Parboiled.createParser(ProjectParser.class);
    }

    @Test
    public void should_parse_a_dependency() {

        String input = aProject().definition("")
                                .withDependencies(
                                        aDependency().groupId("org.springframework")
                                                .artifactId("spring-core")
                                                .version("3.0.5.RELEASE")
                                ).toString();

        ParsingResult<?> result = new RecoveringParseRunner(parser.Dependencies()).run(input);

        LOGGER.info("{} = {}", input, result.parseTreeRoot.getValue());
        LOGGER.info("{}", ParseTreeUtils.printNodeTree(result));

        if (!result.matched) {
            LOGGER.error("{}", StringUtils.join(result.parseErrors, "---\n"));
        }

        assertTrue(result.matched);

    }


    @Test
    public void should_parse_dependencies_grouped() {


        String input = aProject().definition("")
                .withDependencies(
                        aGroupOfDependency().groupId("org.springframework")
                                            .version("3.0.5.RELEASE")
                                            .withArtifactId("spring-core")
                                            .withArtifactId("spring-web")
                ).toString();

        ParsingResult<?> result = new RecoveringParseRunner(parser.Dependencies()).run(input);

        LOGGER.info("{} = {}", input, result.parseTreeRoot.getValue());
        LOGGER.info("{}", ParseTreeUtils.printNodeTree(result));

        if (!result.matched) {
            LOGGER.error("{}", StringUtils.join(result.parseErrors, "---\n"));
        }

        assertTrue(result.matched);

    }
}
