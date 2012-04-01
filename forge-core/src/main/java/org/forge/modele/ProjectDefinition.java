package org.forge.modele;

public class ProjectDefinition {

    private String groupdId;
    private String artifactId;
    private String version;

    public ProjectDefinition() {

    }

    public String getGroupdId() {
        return groupdId;
    }

    public void setGroupdId(String groupdId) {
        this.groupdId = groupdId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public boolean isValid() {
        System.out.println(this);

        if (version == null || version.isEmpty()) {
            return false;
        }

        if (groupdId == null || groupdId.isEmpty()) {
            return false;
        }

        if (artifactId == null || artifactId.isEmpty()) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "Project{" +
                "groupdId='" + groupdId + '\'' +
                ", artifactId='" + artifactId + '\'' +
                ", version='" + version + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjectDefinition)) return false;

        ProjectDefinition projectDefinition = (ProjectDefinition) o;

        if (!artifactId.equals(projectDefinition.artifactId)) return false;
        if (!groupdId.equals(projectDefinition.groupdId)) return false;
        if (!version.equals(projectDefinition.version)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = groupdId.hashCode();
        result = 31 * result + artifactId.hashCode();
        result = 31 * result + version.hashCode();
        return result;
    }
}
