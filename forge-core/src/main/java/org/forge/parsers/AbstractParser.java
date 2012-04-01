package org.forge.parsers;

import org.forge.exceptions.UnknownCommand;

public class AbstractParser implements Parser<Void> {

    private static final String FORGE_FILE = "forge";

    private static final String FORGE = "project {\n" +
            "\torg.forge:forge:$version\n" +
            "}\n" +
            "\n" +
            "modules {\n" +
            "\torg.forge::$version {\n" +
            "\t\tforge-core\n" +
            "\t\tforge-api\n" +
            "\t\tforge-manager\n" +
            "\t}\n" +
            "}\n" +
            "\n" +
            "// dependencies repo\n" +
            "repositories {\n" +
            "\thttp://nexus.com/repo/public\n" +
            "}\n" +
            "\n" +
            "dependencies {\n" +
            "\torg.springframework::2.2.2 {\n" +
            "\t\t\tspring-batch:2.2.3\n" +
            "\t\t\tspring-jdbc:3.0.5FINAL\n" +
            "\t\t\tspring-core\n" +
            "\t}\n" +
            "\tscope:test {\n" +
            "\t\torg.hsqldb:hsqldb:1.8.0.10\t\n" +
            "\t}\n" +
            "}";


    public Void parse() {
               return null;
    }

    private static final String BEGIN_BLOCK = "{";
    private static final String END_BLOCK = "}";


    public COMMANDS readCommand(String flux) {
        return COMMANDS.valueOf((flux.substring(0, flux.indexOf(BEGIN_BLOCK)).trim()));
    }

//    public Block readBlock(String flux) {
//        COMMANDS commands = readCommand(flux);
//        Block block;
////           block.setCommand(command);
//
//        switch(commands) {
//            case PROJECT : block = new Project();break;
//            default:throw new UnknownCommand();    //  FIX ME: NE PEUT PAS ARRIVER !!
//        }
//
//        return block;
//    }


    public enum COMMANDS {
        PROJECT;
    }



}
