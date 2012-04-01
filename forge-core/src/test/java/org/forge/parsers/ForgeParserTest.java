package org.forge.parsers;


import org.forge.exceptions.MandatoryParameterException;
import org.forge.exceptions.NoDefinitionException;
import org.forge.modele.Forge;
import org.forge.modele.Project;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ForgeParserTest {


    @Test
    public void parse_should_detect_one_blocks() {
        ForgeParser forgeParser = new ForgeParser("project { \\n }\\n");

        Forge forge = forgeParser.parse();
        Block block = new Block();
        block.setCommand("project");
        block.setParameters("\\n");

        assertEquals("Parser did not detect one block", 1, forge.getBlocks().size());
        assertTrue("It is not expected block", forge.getBlocks().contains(block));

    }

    @Test
    public void parse_should_detect_two_blocks() {
        ForgeParser forgeParser = new ForgeParser("project { \\n }\\n repositories { \\n }\\n");

        Forge forge = forgeParser.parse();

        Block block = new Block();
        block.setCommand("project");
        block.setParameters("\\n");


        assertEquals("Parser did not detect two blocks", 2, forge.getBlocks().size());
        assertEquals("It is not expected blocks", forge.getBlocks().equals(block));

    }
}
