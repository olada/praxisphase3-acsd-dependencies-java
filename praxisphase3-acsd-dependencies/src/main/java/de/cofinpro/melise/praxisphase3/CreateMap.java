package de.cofinpro.melise.praxisphase3;

import java.io.*;
import java.util.*;

public class CreateMap {

    public static void writeMap() {
        try {
            //Mapping Tree-Objects
            HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("0", "[{ \"name\": \"Top Level NEW1\", \"parent\": \"null\", \"children\": [{ \"name\": \"Level 2: A\", \"parent\": \"Top Level NEW1\", \"children\": [{ \"name\": \"Son of A\", \"parent\": \"Level 2: A\", \"children\": [{ \"name\": \"Grandson of A\", \"parent\": \"Son of A\" }, { \"name\": \"Granddaughter of A\", \"parent\": \"Son of A\" }, { \"name\": \"Granddaughter of A\", \"parent\": \"Son of A\" }] }, { \"name\": \"Daughter of A\", \"parent\": \"Level 2: A\", \"children\": [{ \"name\": \"Granddaughter of A\", \"parent\": \"Daughter of A\" }] }] }, { \"name\": \"Level 2: B\", \"parent\": \"Top Level NEW1\", \"children\": [{ \"name\": \"Son of B\", \"parent\": \"Level 2: B\" }, { \"name\": \"Daughter of B\", \"parent\": \"Level 2: B\" }] }] }]");
            hashMap.put("1", "[{\"name\":\"Top Level\",\"parent\":\"null\",\"children\":[{\"name\":\"Level 2: A\",\"parent\":\"Top Level\",\"children\":[{\"name\":\"Son of A\",\"parent\":\"Level 2: A\",\"children\":[{\"name\":\"Grandson of A\",\"parent\":\"Son of A\"},{\"name\":\"Granddaughter of A\",\"parent\":\"Son of A\"}]},{\"name\":\"Daughter of A\",\"parent\":\"Level 2: A\",\"children\":[{\"name\":\"Granddaughter of A\",\"parent\":\"Daughter of A\"}]}]},{\"name\":\"Level 2: B\",\"parent\":\"Top Level\",\"children\":[{\"name\":\"Son of B\",\"parent\":\"Level 2: B\"},{\"name\":\"Daughter of B\",\"parent\":\"Level 2: B\"}]}]}]");
            /* hashMap.put("2","[{\"name\":\"Top Level\",\"parent\":\"null\",\"children\":[{\"name\":\"Level 2: A\",\"parent\":\"Top Level\",\"children\":[{\"name\":\"Son of A\",\"parent\":\"Level 2: A\",\"children\":[{\"name\":\"Grandson of A\",\"parent\":\"Son of A\"},{\"name\":\"Granddaughter of A\",\"parent\":\"Son of A\"}]},{\"name\":\"Daughter of A\",\"parent\":\"Level 2: A\",\"children\":[{\"name\":\"Granddaughter of A\",\"parent\":\"Daughter of A\"}]}]},{\"name\":\"Level 2: B\",\"parent\":\"Top Level\",\"children\":[{\"name\":\"Son of B\",\"parent\":\"Level 2: B\"},{\"name\":\"Daughter of B\",\"parent\":\"Level 2: B\"}]}]}]");
             */
            // Create new file

            //Content of Map File
            String content =
                    " var myMap = new Map();\n" +
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
            Iterator iteratorKey = hashMap.keySet().iterator();
            Iterator iteratorValue = hashMap.values().iterator();

            System.out.println(" var myMap = new Map();\n");

            // Write generally in file
            bufferedWriter.write(" var myMap = new Map();\n");

            while (iteratorKey.hasNext()) {
                String iteratorGetKey = iteratorKey.next().toString();
                String iteratorGetValue = iteratorValue.next().toString();

                System.out.println("    myMap.set('" + iteratorGetKey + "', '" + iteratorGetValue + "');\n");

                // Write HashMap Data in file
                bufferedWriter.write("    myMap.set('" + iteratorGetKey + "', '" + iteratorGetValue + "');\n");
            }

            // Close Writer
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CreateMap createMap = new CreateMap();
        createMap.writeMap();
    }

}
