package org.forge;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: sebastien
 * Date: 17/04/12
 * Time: 17:22
 */
public class ProjectBuilder {


    private String description;
    private String definition;

    private Collection<DependencyBuilder> dependencyBuilder;

    public ProjectBuilder() {
        dependencyBuilder = new HashSet<DependencyBuilder>();
    }

    public ProjectBuilder description(String description) {
        this.description = description;
        return this;
    }

    public ProjectBuilder definition(String definition) {
        this.definition = definition;
        return this;
    }

    public ProjectBuilder withDependencies(DependencyBuilder... dependencies) {
        for (DependencyBuilder dependency : dependencies) {
            this.dependencyBuilder.add(dependency);
        }

        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(definition).append("\n").append(description).append("\n");
        for (DependencyBuilder dependency : dependencyBuilder) {
            sb.append(this.dependencyBuilder.toString());
        }

        return sb.toString();
    }
}
