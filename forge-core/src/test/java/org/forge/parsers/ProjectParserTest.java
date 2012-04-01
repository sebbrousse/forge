package org.forge.parsers;


import org.forge.exceptions.MandatoryParameterException;
import org.forge.exceptions.NoDefinitionException;
import org.forge.modele.Project;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProjectParserTest {

    @Test(expected = MandatoryParameterException.class)
    public void read_empty_project_should_return_MandatoryParameterException() {
        ProjectParser project = new ProjectParser("");
        project.parse();
    }

    @Test(expected = NoDefinitionException.class)
    public void read_project_should_have_at_least_project_definition() {
        ProjectParser projectBlock = new ProjectParser("no definition");
        projectBlock.parse();
    }

    @Test
    public void read_valid_project_should_return_expected_project() {
        ProjectParser projectBlock = new ProjectParser("");
        Project project = projectBlock.parse();
        Project expectedProject = new Project();

        assertEquals("did not return expected project", project, expectedProject);
    }

    public void read_project_should_parse_project() {

    }

    @Test
    public void default_project_parameter_is_project_definition() {
        ProjectParser project = new ProjectParser("org.forge:forge-core:1.0");
        project.parse();


    }

    @Test
    public void a_project_can_have_a_description() {
        ProjectParser projectBlock = new ProjectParser("org.forge:forge-core:1.0\ndescription:Project Description");
        Project project = projectBlock.parse();


    }
}
