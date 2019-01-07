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

    public List<String> getTsvFile() throws Exception {
        Path path = Paths.get(getClass().getClassLoader().getResource("co#sap.tsv").toURI());
        List<String> tsvFile = Files.readAllLines(path);
        return tsvFile;
    }

    public String getAttributeID() {
        System.out.println("Enter your attribute-ID: ");
        String attributeID = scanner.nextLine();
        return attributeID;
    }

    //vorher nachher test der Map oder Map zurück geben (in Zusammenhang mit executeAllMethods())
    public HashMap<String, SdAttribute> splitTsv(List<String> tsvFile) {
        HashMap<String, SdAttribute> map = new HashMap<>();

        for (String dataRow : tsvFile) {
            String[] dataArray = dataRow.split("\t");
            String id = dataArray[INDEX_ID];
            String description = dataArray[INDEX_DESCRIPTION];
            fillMap(map, id, description);
        }
        return map;
    }

    //teste vorher nachher der Map
    public void fillMap(HashMap<String, SdAttribute> map, String id, String description) {

        SdAttribute sdAttribute = new SdAttribute(id, description);
        map.put(id, sdAttribute);

        Node node = new Node(sdAttribute);
        System.out.println( node.getValue().toString());
    }

    public void printAttributeByInput(HashMap<String, SdAttribute> map, String attributeID) {
        if (map.containsKey(attributeID)) {

            System.out.println("your Attribute-ID:" + map.get(attributeID));
        }
    }

    public void printMapSize(HashMap<String, SdAttribute> map) {
        System.out.println(map.size());
    }

    public void executeAllMethods() throws Exception {
        List<String> tsvFile = getTsvFile();
        HashMap<String, SdAttribute> map = new HashMap<>();

        String attributeID = getAttributeID();
        splitTsv(tsvFile);
        printAttributeByInput(map, attributeID);
        printMapSize(map);
    }

}
