package org.forge.parsers;

import org.forge.exceptions.MandatoryParameterException;
import org.forge.modele.Forge;
import org.forge.modele.ProjectDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.MatchResult;

public class ForgeParser implements Parser<Forge>{


    private static Logger LOGGER = LoggerFactory.getLogger(ForgeParser.class);

    private String flux;


    private Map<String, Object> blocks = new HashMap();

    public ForgeParser(String flux) {
        this.flux = flux;
    }

    public Forge parse() {
        String pattern = "project {\n org.forge:forge-core:1.0 \n description : hello \n }\n";
        LOGGER.debug(pattern);
        Scanner scanner = new Scanner(pattern);
        scanner.findWithinHorizon("[\\s|\\n]*(.+)[\\s|\\n]*\\{[\\s|\\n]*(.*)[\\s|\\n]*",0);
//        scanner.findWithinHorizon("[\\s|\\n]*(.+)[\\s|\\n]*\\{[\\s|\\n]*(.*)[\\s|\\n]*(.*)[\\s|\\n]*\\}[\\s|\\n]*",0);

        MatchResult result = scanner.match();
        for (int i=1; i<=result.groupCount(); i++) {
            LOGGER.debug("command : \"{}\"",result.group(i));
        }
        scanner.close();

        return null;
    }


    public static void main(String[] args) {
        ForgeParser parser = new ForgeParser("project { \nhelllo }\n");
        parser.parse();
    }



}
