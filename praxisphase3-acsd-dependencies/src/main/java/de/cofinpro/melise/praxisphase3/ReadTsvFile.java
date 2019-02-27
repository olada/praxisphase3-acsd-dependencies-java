package de.cofinpro.melise.praxisphase3;
/** Klasse where the magic happens.
 * Klasse liest co#sap ein und erzeugt map in der die erste spalte (die Id) als key abgespeichert und die zweite spalte(description) als value gespeichert wird
 * Klasse liest co#sad ein und setzt die Nodes in Beziehung zueinander links=Kind ,rechts=parent
 * schreibt alle Jsons der Bäume in Javascript-Datei */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class ReadTsvFile {

    public static final int LEFT_ATTRIBUTE = 0;
    private static final int INDEX_ID = 0;
    private static final int INDEX_DESCRIPTION = 1;
    public static final int RIGHT_ATTRIBUTE = 1;

    //gets TSV File from path
    public List<String> readAttributeDeclarationsFile() throws Exception {
        Path path = Paths.get(getClass().getClassLoader().getResource("co#sap.tsv").toURI());
        List<String> linesOfAttributeDeclarations = Files.readAllLines(path);

        //removed Header (first Line)
        linesOfAttributeDeclarations.remove(0);

        return linesOfAttributeDeclarations;
    }


    //Splits FIle into Tab seperated Values
    public Map<String, Node> createMapFromAttributeDeclarations(List<String> linesOfAttributeDeclarations) {
        Map<String, Node> map = new HashMap<>();
        for (String dataRow : linesOfAttributeDeclarations) {

            String[] dataArray = dataRow.split("\t");
            String id = dataArray[INDEX_ID];
            String description = dataArray[INDEX_DESCRIPTION];
            fillMap(map, id, description);
        }

        return map;
    }

    //fills Map with id and description
    public void fillMap(Map<String, Node> map, String id, String description) {
        SdAttribute sdAttribute = new SdAttribute(id, description);
        Node node = new Node(sdAttribute);
        map.put(id, node);

    }


    public void executeAllMethods() throws Exception {
        List<String> linesOfAttributeDeclarations = readAttributeDeclarationsFile();

        /**
         * ########################
         * START EINLESEN VON CO#SAD.TSV [AttributeDependenciesFile]
         * ########################
         */
        Path sadPath = Paths.get(getClass().getClassLoader().getResource("co#sad.tsv").toURI());
        List<String> linesOfAttributeDependencies = Files.readAllLines(sadPath);

        //removed Header (first Line)
        linesOfAttributeDependencies.remove(0);

        /**
         * ENDE EINLESEN VON CO#SAD.TSV
         */

        Map<String, Node> attributeNodesMap = createMapFromAttributeDeclarations(linesOfAttributeDeclarations);
        /**
         * ########################
         * START Nodes in Beziehung zueinander setzen (Links = Kind von rechts -> bezogen auf co#sad.tsv [AttributeDependenciesFile])
         * ########################
         */

        for (String dataRow : linesOfAttributeDependencies) {

            if (dataRow.contains("\t")) {

                String[] dataRowArray = dataRow.split("\t");
                String leftAttributeId = dataRowArray[LEFT_ATTRIBUTE];
                String rightAttributeId = dataRowArray[RIGHT_ATTRIBUTE];
                Node nodeOfLeftAttribute = attributeNodesMap.get(leftAttributeId);
                Node nodeOfRightAttribute = attributeNodesMap.get(rightAttributeId);

                if (nodeOfLeftAttribute != null && nodeOfRightAttribute != null) {
                    nodeOfRightAttribute.add(nodeOfLeftAttribute);
                }

            }

        }

        /**
         * ENDE Nodes in Beziehung zueinander setzen (Links = Kind von rechts -> bezogen auf co#sad.tsv [AttributeDependenciesFile])
         */


        /**
         * ########################
         * START zur Usereingabe passendes Json in JavascriptDatei schreiben
         * ########################
         */

        File file = new File("C:\\Develop\\Melise\\workspace\\praxisphase3-acsd-dependencies-frontend\\JavaOutput.js");
        file.delete();
        file.createNewFile();

        try (BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file, true))) {

            bufferedwriter.write("var myMap = new Map();");

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file, true))) {
            for (String attributeId : attributeNodesMap.keySet()) {
                JsonNode attributeJsonNode = new JsonNode(attributeNodesMap.get(attributeId));
                bufferedwriter.write("\n");
                bufferedwriter.write("myMap.set(" + " '" + attributeId + "' , '[" + attributeJsonNode.toJson() + "]');");

            }
        } catch (IOException e) {

            e.printStackTrace();
        }
        /**
         * ENDE zur Usereingabe passendes Json in JavascriptDatei schreiben
         */
    }

}
