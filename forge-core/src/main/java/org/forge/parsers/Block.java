package org.forge.parsers;

import java.util.Collection;

public class Block {
    
    private String command;

    private String parameters;


    public void setCommand(String command) {
        this.command = command;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "Block{" +
                "command='" + command + '\'' +
                ", parameters='" + parameters + '\'' +
                '}';
    }
}
