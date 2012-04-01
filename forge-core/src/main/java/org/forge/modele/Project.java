package org.forge.modele;

public class Project {

    private ProjectDefinition projectDefinition;
    private String description;

    public ProjectDefinition getProjectDefinition() {
        return projectDefinition;
    }

    public void setProjectDefinition(ProjectDefinition projectDefinition) {
        this.projectDefinition = projectDefinition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project)) return false;

        Project project = (Project) o;

        if (description != null ? !description.equals(project.description) : project.description != null) return false;
        if (projectDefinition != null ? !projectDefinition.equals(project.projectDefinition) : project.projectDefinition != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = projectDefinition != null ? projectDefinition.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectDefinition=" + projectDefinition +
                ", description='" + description + '\'' +
                '}';
    }

    public boolean isValid() {
        return false;
    }
}
