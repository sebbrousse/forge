package org.forge.parsers;

import org.parboiled.BaseParser;
import org.parboiled.Rule;
import org.parboiled.annotations.BuildParseTree;
import org.parboiled.support.Var;
import org.parboiled.trees.BinaryTreeNode;
import org.parboiled.trees.ImmutableBinaryTreeNode;
import org.parboiled.trees.ImmutableTreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: sebastien
 * Date: 17/04/12
 * Time: 15:43
 */
@BuildParseTree
public class DependenciesParser extends BaseParser<Object> {

    Rule Dependencies() {
        return Sequence(
                "dependencies", '{',
                OneOrMore(
                        FirstOf(Dependency(),
                                GroupDependencies()
                        )
                ),
                '}'
        );
    }

    Rule Dependency() {
        Var<String> groupdId = new Var<String>();
        Var<String> artifactId = new Var<String>();
        Var<String> version = new Var<String>();

        return Sequence(
                GroupId(),groupdId.set(match()),
                ':',
                ArtifactId(),artifactId.set(match()),
                ':',
                Version(),version.set(match()),
                ZeroOrMore(','),
                push(new Dependency(groupdId.get(), artifactId.get(), version.get()))
        );
    }

    Rule GroupDependencies() {
        return Sequence(
                GroupId(),
                ':',
                ':',
                Version(),
                '{',
                OneOrMore(ArtifactDependency()),
                '}'
        );
    }

    Rule ArtifactDependency() {
        return Sequence(
                ArtifactId(),
                ','
        );
    }

    Rule GroupId() {
        return OneOrMore(FirstOf(CharRange('a', 'z'), CharRange('A', 'Z'), '.', '-'));
    }

    Rule ArtifactId() {
        return OneOrMore(FirstOf(CharRange('a', 'z'), CharRange('A', 'Z'), '.', '-'));
    }

    Rule Version() {
        return OneOrMore(FirstOf(CharRange('0', '9'), CharRange('a', 'z'), CharRange('A', 'Z'), '.'));
    }


    public class Dependency extends ImmutableTreeNode {

         String groupdId;
        String artifactId;
        String version;

         public Dependency(String groupId, String artifactId, String version) {
             this.groupdId = groupId;
             this.artifactId = artifactId;
             this.version = version;

         }

        @Override
        public String toString() {
            return "groupId = "+groupdId;    //To change body of overridden methods use File | Settings | File Templates.
        }
    }

}