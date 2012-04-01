package org.forge.parsers;


import org.forge.exceptions.UnknownCommand;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {


    @Test
    public void read_command_project_should_return_project_enum() {
        AbstractParser parser = new AbstractParser();
        AbstractParser.COMMANDS command = parser.readCommand("PROJECT {");

        assertEquals("command is not PROJECT", command, AbstractParser.COMMANDS.PROJECT);
    }

    @Test
    public void read_command_project_should_ignore_case() {
        AbstractParser parser = new AbstractParser();
        AbstractParser.COMMANDS command = parser.readCommand("project {");

        assertEquals("command is not PROJECT", command, AbstractParser.COMMANDS.PROJECT);
    }

    @Test
    public void read_command_project_should_trim() {
        AbstractParser parser = new AbstractParser();
        AbstractParser.COMMANDS command = parser.readCommand("   project {");

        assertEquals("command is not PROJECT", command, AbstractParser.COMMANDS.PROJECT);
    }

    @Test(expected = UnknownCommand.class)
    public void read_unknown_command_should_throw_an_UnknownCommandException() {
        AbstractParser parser = new AbstractParser();
        parser.readCommand("UNKNOWN {");
    }
}
