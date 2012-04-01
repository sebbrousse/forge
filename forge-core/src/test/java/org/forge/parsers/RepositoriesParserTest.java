package org.forge.parsers;

import org.junit.Test;
import org.parboiled.Parboiled;
import org.parboiled.common.StringUtils;
import org.parboiled.parserunners.RecoveringParseRunner;
import org.parboiled.support.ParseTreeUtils;
import org.parboiled.support.ParsingResult;

/**
 * Created by IntelliJ IDEA.
 * User: Sébastien
 * Date: 01/04/12
 * Time: 15:17
 */
public class RepositoriesParserTest {

    @Test
    public void test() {
        RepositoriesParser parser = Parboiled.createParser(RepositoriesParser.class);


        String input = "custom:http://nexus.com/repo/public";
        ParsingResult<?> result = new RecoveringParseRunner(parser.Repository()).run(input);

        System.out.println(input + " = " + result.parseTreeRoot.getValue() + '\n');
        System.out.println(ParseTreeUtils.printNodeTree(result) + '\n');

        if (!result.matched) {
            System.out.println(StringUtils.join(result.parseErrors, "---\n"));
        }
    }
}
