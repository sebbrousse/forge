package org.forge.parsers;

import org.forge.exceptions.MandatoryParameterException;
import org.forge.modele.Project;
import org.forge.modele.ProjectDefinition;

import java.util.StringTokenizer;

public class ProjectDefinitionParser implements Parser<ProjectDefinition> {


    private String flux;

    public ProjectDefinitionParser(String flux) {
        this.flux = flux;
    }

    @Override
    public ProjectDefinition parse() {
        StringTokenizer tokenizer = new StringTokenizer(flux, ":");

        if (tokenizer.countTokens() != 3) {
            throw new MandatoryParameterException();
        }

        ProjectDefinition projectDefinition = new ProjectDefinition();

        projectDefinition.setGroupdId(tokenizer.nextToken());
        projectDefinition.setArtifactId(tokenizer.nextToken());
        projectDefinition.setVersion(tokenizer.nextToken());

        if (!projectDefinition.isValid()) {
            throw new MandatoryParameterException();
        }

        return projectDefinition;
    }
}
