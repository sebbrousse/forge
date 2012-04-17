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
 * Created by IntelliJ IDEA.
 * User: Sébastien
 * Date: 01/04/12
 * Time: 15:17
 */
public class RepositoriesParserTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(RepositoriesParserTest.class);


    @Test
    public void test() {
        RepositoriesParser parser = Parboiled.createParser(RepositoriesParser.class);


        String input = "custom:http://nexus.com/repo/public";
        ParsingResult<?> result = new RecoveringParseRunner(parser.Repository()).run(input);

        LOGGER.info("{} = {}", input, result.parseTreeRoot.getValue());
        LOGGER.info("{}", ParseTreeUtils.printNodeTree(result));

        if (!result.matched) {
            LOGGER.error("{}", StringUtils.join(result.parseErrors, "---\n"));
        }

        assertTrue(result.matched);


    }
}
