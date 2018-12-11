package de.cofinpro.melise.praxisphase3;

import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ReadTsvFile {

    public void readTsv() throws Exception {

        Path path = Paths.get("C:/Develop/Melise/workspace/praxisphase3-acsd-dependencies-java/praxisphase3-acsd-dependencies/src/main/resources/co#sad.tsv");
        List<String> tsvFile = Files.readAllLines(path, Charset.defaultCharset());
        String id;
        String description;
        SdAttribute sdAttribute;
        HashMap<String, SdAttribute> map;

        if (tsvFile != null) {
            Iterator<String> datarow = tsvFile.iterator();
            while (datarow.hasNext()) {
                String[] dataArray = datarow.next().split("\t");
                map= new HashMap<>();
                for (int i=0; i<dataArray.length; i++){
                    id=dataArray[0];
                    description=dataArray[1];
                    sdAttribute=new SdAttribute(id,description);
                    map.put(id, sdAttribute);
                }

                /*System.out.println(map.values());*/
                System.out.println(map.size());
            }
        }
    }
    public static void main(String[] args) throws Exception{
        ReadTsvFile readTsvFile= new ReadTsvFile();
        readTsvFile.readTsv();
    }
}
