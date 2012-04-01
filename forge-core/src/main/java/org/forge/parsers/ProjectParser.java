package org.forge.parsers;

import org.forge.exceptions.MandatoryParameterException;
import org.forge.modele.Project;
import org.forge.modele.ProjectDefinition;

import java.util.StringTokenizer;

public class ProjectParser implements Parser<Project> {

    private String flux;

    public ProjectParser(String flux) {
        this.flux = flux;
    }

    @Override
    public Project parse() {
//        if (flux == null || flux.isEmpty()) {
//            throw new MandatoryParameterException();
//        }
//
//
//        ProjectParser projectParser = new ProjectParser(flux);
//        ProjectBlock project;
//        try {
//            project = projectParser.parse();
//        } catch(MandatoryParameterException e) {
//            throw new NoDefinitionException();
//        }
//
//
//        return project;


        StringTokenizer tokenizer = new StringTokenizer(flux, "\n");

        if (tokenizer.countTokens() != 3) {
            throw new MandatoryParameterException();
        }

        Project project = new Project();

        ProjectDefinitionParser projectDefinitionParser = new ProjectDefinitionParser(tokenizer.nextToken());
        ProjectDefinition projectDefinition = projectDefinitionParser.parse();


        project.setProjectDefinition(projectDefinition);
        project.setDescription(tokenizer.nextToken());

        if (!project.isValid()) {
            throw new MandatoryParameterException();
        }

        return project;
    }
}
