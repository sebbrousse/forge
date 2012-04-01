package org.forge.modele;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ProjectDefinitionTest {


    @Test
    public void a_definition_with_no_version_is_invalid() {
        ProjectDefinition project = new ProjectDefinition();

        project.setGroupdId("org.forge");
        project.setArtifactId("forge-core");

        assertFalse("project should be invalid", project.isValid());
    }


    @Test
    public void a_definition_with_no_groupId_is_invalid() {
        ProjectDefinition project = new ProjectDefinition();

        project.setVersion("1.0");
        project.setArtifactId("forge-core");

        assertFalse("project should be invalid", project.isValid());
    }

    @Test
    public void a_definition_with_no_artifactId_is_invalid() {
        ProjectDefinition project = new ProjectDefinition();

        project.setGroupdId("org.forge");
        project.setVersion("1.0");

        assertFalse("project should be invalid", project.isValid());
    }

    @Test
    public void a_complete_definition_is_valid() {
        ProjectDefinition project = new ProjectDefinition();

        project.setGroupdId("org.forge");
        project.setArtifactId("forge-core");
        project.setVersion("1.0");

        assertTrue("project should be valid", project.isValid());
    }

}
