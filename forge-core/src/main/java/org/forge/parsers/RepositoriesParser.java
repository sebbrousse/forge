package org.forge.parsers;

import org.parboiled.BaseParser;
import org.parboiled.Rule;
import org.parboiled.annotations.BuildParseTree;

/**
 * Created by IntelliJ IDEA.
 * User: Sébastien
 * Date: 01/04/12
 * Time: 15:05
 */
@BuildParseTree
public class RepositoriesParser extends BaseParser<Object> {

        Rule Repository() {
            return Sequence(
                    Id(),
                    ':',
                    Url()
            );
        }

        Rule Id() {
            return  OneOrMore(FirstOf(CharRange('a', 'z'), CharRange('A', 'Z')));
        }

        Rule Url() {
            return   OneOrMore(FirstOf(CharRange('a', 'z'), CharRange('A', 'Z'), ':', '/', '.'));
        }

}
