package org.forge;

/**
 * Created with IntelliJ IDEA.
 * User: sebastien
 * Date: 17/04/12
 * Time: 22:24
 */
public class Builders {

    public static ProjectBuilder aProject() {
        return new ProjectBuilder();
    }


    public static DependencyBuilder aDependency() {
        return new DependencyBuilder();
    }

    public static DependencyGroupBuilder aGroupOfDependency() {
        return new DependencyGroupBuilder();
    }


}
