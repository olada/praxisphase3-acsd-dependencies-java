package de.cofinpro.melise.praxisphase3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.*;

public class CreateMap {

    public static void writeMap() throws IOException {
        try {
            // Create new file
            /*String mapContent;
            Map myMap = new Map();
            myMap.put('0', '[{ "name": "Top Level NEW1", "parent": "null", "children": [{ "name": "Level 2: A", "parent": "Top Level NEW1", "children": [{ "name": "Son of A", "parent": "Level 2: A", "children": [{ "name": "Grandson of A", "parent": "Son of A" }, { "name": "Granddaughter of A", "parent": "Son of A" }, { "name": "Granddaughter of A", "parent": "Son of A" }] }, { "name": "Daughter of A", "parent": "Level 2: A", "children": [{ "name": "Granddaughter of A", "parent": "Daughter of A" }] }] }, { "name": "Level 2: B", "parent": "Top Level NEW1", "children": [{ "name": "Son of B", "parent": "Level 2: B" }, { "name": "Daughter of B", "parent": "Level 2: B" }] }] }]');
            myMap.put('1', '[{"name":"Top Level","parent":"null","children":[{"name":"Level 2: A","parent":"Top Level","children":[{"name":"Son of A","parent":"Level 2: A","children":[{"name":"Grandson of A","parent":"Son of A"},{"name":"Granddaughter of A","parent":"Son of A"}]},{"name":"Daughter of A","parent":"Level 2: A","children":[{"name":"Granddaughter of A","parent":"Daughter of A"}]}]},{"name":"Level 2: B","parent":"Top Level","children":[{"name":"Son of B","parent":"Level 2: B"},{"name":"Daughter of B","parent":"Level 2: B"}]}]}]');
            */

            String content = " var myMap = new Map();\n" +
                    "    myMap.set('0', '[{ \"name\": \"Top Level NEW1\", \"parent\": \"null\", \"children\": [{ \"name\": \"Level 2: A\", \"parent\": \"Top Level NEW1\", \"children\": [{ \"name\": \"Son of A\", \"parent\": \"Level 2: A\", \"children\": [{ \"name\": \"Grandson of A\", \"parent\": \"Son of A\" }, { \"name\": \"Granddaughter of A\", \"parent\": \"Son of A\" }, { \"name\": \"Granddaughter of A\", \"parent\": \"Son of A\" }] }, { \"name\": \"Daughter of A\", \"parent\": \"Level 2: A\", \"children\": [{ \"name\": \"Granddaughter of A\", \"parent\": \"Daughter of A\" }] }] }, { \"name\": \"Level 2: B\", \"parent\": \"Top Level NEW1\", \"children\": [{ \"name\": \"Son of B\", \"parent\": \"Level 2: B\" }, { \"name\": \"Daughter of B\", \"parent\": \"Level 2: B\" }] }] }]');\n" +
                    "    myMap.set('1', '[{\"name\":\"Top Level\",\"parent\":\"null\",\"children\":[{\"name\":\"Level 2: A\",\"parent\":\"Top Level\",\"children\":[{\"name\":\"Son of A\",\"parent\":\"Level 2: A\",\"children\":[{\"name\":\"Grandson of A\",\"parent\":\"Son of A\"},{\"name\":\"Granddaughter of A\",\"parent\":\"Son of A\"}]},{\"name\":\"Daughter of A\",\"parent\":\"Level 2: A\",\"children\":[{\"name\":\"Granddaughter of A\",\"parent\":\"Daughter of A\"}]}]},{\"name\":\"Level 2: B\",\"parent\":\"Top Level\",\"children\":[{\"name\":\"Son of B\",\"parent\":\"Level 2: B\"},{\"name\":\"Daughter of B\",\"parent\":\"Level 2: B\"}]}]}]');\n";
            String path = "C:/Develop/Melise/workspace/praxisphase3-acsd-dependencies-java/praxisphase3-acsd-dependencies/src/main/resources/MapBeispiel.js";
            File fileData = new File(path);

            // If file doesn't exists, then create it
            if (!fileData.exists()) {
                fileData.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(fileData.getAbsoluteFile());
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Write in filegjkbghzki
            bufferedWriter.write(content);

            // Close
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public static void main(String[] args)throws IOException {
        CreateMap createMap= new CreateMap();
        createMap.writeMap();
    }

}

