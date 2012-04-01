package org.forge.parsers;


import org.forge.exceptions.MandatoryParameterException;
import org.forge.modele.Project;
import org.forge.modele.ProjectDefinition;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProjectDefinitionParserTest {

    @Test(expected = MandatoryParameterException.class)
    public void read_empty_project_should_return_MandatoryParameterException() {
        ProjectDefinitionParser project = new ProjectDefinitionParser("");
        project.parse();
    }

    @Test(expected = MandatoryParameterException.class)
    public void read_project_should_have_3_parameters() {
        ProjectDefinitionParser projectBlock = new ProjectDefinitionParser("forge-core:1.0");
        ProjectDefinition project = projectBlock.parse();
    }

    @Test(expected = MandatoryParameterException.class)
    public void read_invalid_project_should_throw_MandatoryParameterException() {
        ProjectDefinitionParser projectBlock = new ProjectDefinitionParser("org.forge::1.0");
        ProjectDefinition project = projectBlock.parse();
    }



    @Test
    public void read_project_should_return_project() {
        ProjectDefinitionParser project = new ProjectDefinitionParser("org.forge:forge-core:1.0");
        ProjectDefinition project1 = project.parse();

        ProjectDefinition expectedProject = new ProjectDefinition();
        expectedProject.setGroupdId("org.forge");
        expectedProject.setArtifactId("forge-core");
        expectedProject.setVersion("1.0");
        assertEquals("did not return expected project", project1, expectedProject);
    }
}
