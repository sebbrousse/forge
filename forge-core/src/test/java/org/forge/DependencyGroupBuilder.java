package org.forge;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: sebastien
 * Date: 17/04/12
 * Time: 22:47
 */
public class DependencyGroupBuilder extends DependencyBuilder {

    private String groupId;
    private Collection<String> artifactIds;
    private String version;

    public DependencyGroupBuilder() {
        artifactIds = new HashSet<String>();
    }

    @Override
    public DependencyGroupBuilder groupId(String groupId) {
        this.groupId = groupId;
        return this;
    }

    @Override
    public DependencyGroupBuilder version(String version) {
        this.version = version;
        return this;
    }

    public DependencyGroupBuilder withArtifactId(String artifactId) {
        artifactIds.add(artifactId);
        return this;
    }


}
