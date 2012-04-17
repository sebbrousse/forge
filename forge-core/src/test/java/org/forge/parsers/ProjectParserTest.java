package org.forge.parsers;



import org.forge.exceptions.MandatoryParameterException;
import org.forge.exceptions.NoDefinitionException;
import org.forge.modele.Project;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.parboiled.Parboiled;
import org.parboiled.common.StringUtils;
import org.parboiled.parserunners.RecoveringParseRunner;
import org.parboiled.support.ParseTreeUtils;
import org.parboiled.support.ParsingResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProjectParserTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectParserTest.class);

    private ProjectParser parser;

    @Before
    public void init() {
        parser = Parboiled.createParser(ProjectParser.class);
    }

    @Ignore
    @Test(expected = MandatoryParameterException.class)
    public void read_empty_project_should_return_MandatoryParameterException() {

    }

    @Test(expected = NoDefinitionException.class)
    public void read_project_should_have_at_least_project_definition() {
        ParsingResult<?> result = new RecoveringParseRunner(parser.Project()).run("");
    }

    @Ignore
    @Test
    public void read_valid_project_should_return_expected_project() {
        ParsingResult<?> result = new RecoveringParseRunner(parser.Project()).run("");

        Project expectedProject = new Project();

//        assertEquals("did not return expected project", project, expectedProject);
    }

    @Ignore
    @Test
    public void default_project_parameter_is_project_definition() {
//        ProjectParser project = new ProjectParser("org.forge:forge-core:1.0");
//        project.parse();


    }

    @Ignore
    @Test
    public void a_project_can_have_a_description() {
//        ProjectParser projectBlock = new ProjectParser("org.forge:forge-core:1.0\ndescription:Project Description");
//        Project project = projectBlock.parse();


    }
}
