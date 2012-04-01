package org.forge.modele;

import org.forge.parsers.Block;

import java.beans.beancontext.BeanContextMembershipEvent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Forge {
    private Set<Block> blocks;

    public Forge() {
        this.blocks = new HashSet<Block>();
    }

    public Set<Block> getBlocks() {
        return blocks;
    }

    public void addBlock(Block block) {
        blocks.add(block);
    }
}
