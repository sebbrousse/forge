package org.forge.parsers;

import org.junit.Test;
import org.parboiled.Parboiled;
import org.parboiled.common.StringUtils;
import org.parboiled.parserunners.RecoveringParseRunner;
import org.parboiled.support.ParseTreeUtils;
import org.parboiled.support.ParsingResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: sebastien
 * Date: 17/04/12
 * Time: 16:01
 */
public class DependenciesParserTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(DependenciesParserTest.class);

    @Test
    public void should_parse_a_dependency() {
        DependenciesParser parser = Parboiled.createParser(DependenciesParser.class);


        String input = "org.springframework:spring-core:3.0.5.RELEASE";
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
        DependenciesParser parser = Parboiled.createParser(DependenciesParser.class);


        String input = "org.springframework::3.0.5.RELEASE {\nspring-core,\nspring-web\n}";
        ParsingResult<?> result = new RecoveringParseRunner(parser.Dependencies()).run(input);

        LOGGER.info("{} = {}", input, result.parseTreeRoot.getValue());
        LOGGER.info("{}", ParseTreeUtils.printNodeTree(result));

        if (!result.matched) {
            LOGGER.error("{}", StringUtils.join(result.parseErrors, "---\n"));
        }

        assertTrue(result.matched);

    }
}
