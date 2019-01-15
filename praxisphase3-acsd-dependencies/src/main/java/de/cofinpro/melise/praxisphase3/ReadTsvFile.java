package de.cofinpro.melise.praxisphase3;

import java.nio.file.*;
import java.util.*;

public class ReadTsvFile {

    private static final int INDEX_ID = 0;
    private static final int INDEX_DESCRIPTION = 1;
    private Scanner scanner;

    public ReadTsvFile(Scanner scanner) {
        this.scanner = scanner;

    }

    //gets TSV File from path
    public List<String> getTsvFile() throws Exception {
        Path path = Paths.get(getClass().getClassLoader().getResource("co#sap.tsv").toURI());
        List<String> tsvFile = Files.readAllLines(path);

        //removed Header (first Line)
        tsvFile.remove(0);

        return tsvFile;
    }

    //Gets AttributeId
    public String getAttributeID() {
        System.out.println("Enter your attribute-ID: ");
        String attributeID = scanner.nextLine();

        return attributeID;
    }

    //Splits FIle into Tab seperated Values
    public Map<String, Node> splitTsv(List<String> tsvFile) {
        Map<String, Node> map = new HashMap<>();
        for (String dataRow : tsvFile) {

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

    // prints the Attribute with the same Input Id
    public void printAttributeByInput(Map<String, Node> map, String attributeID) {

        if (map.containsKey(attributeID)) {

            System.out.println("your Attribute-ID is:" + map.get(attributeID).getValue().toString());

        } else {

            System.out.println("NOT a valid attribute-ID");

        }
    }

    //prints the Size of the Map
    public void printMapSize(Map<String, Node> map) {
        System.out.println(map.size());
    }

    public void executeAllMethods() throws Exception {
        List<String> tsvFile = getTsvFile();

        String attributeID = getAttributeID();
        Map<String, Node> map = splitTsv(tsvFile);
        printAttributeByInput(map, attributeID);
        printMapSize(map);
    }

}
