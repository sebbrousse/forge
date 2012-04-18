package org.forge;

/**
 * Created with IntelliJ IDEA.
 * User: sebastien
 * Date: 17/04/12
 * Time: 21:59
 */
public class DependencyBuilder {

    private String groupId;
    private String artifactId;
    private String version;

    public DependencyBuilder groupId(String groupId) {
        this.groupId = groupId;
        return this;
    }

    public DependencyBuilder artifactId(String artifactId) {
        this.artifactId = artifactId;
        return this;
    }


    public DependencyBuilder version(String version) {
        this.version = version;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(groupId).append(":").append(artifactId).append(":").append(version);
        return sb.toString();
    }


}
