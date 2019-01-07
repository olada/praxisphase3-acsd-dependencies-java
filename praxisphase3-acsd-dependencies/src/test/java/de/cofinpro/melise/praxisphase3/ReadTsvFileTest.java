package de.cofinpro.melise.praxisphase3;

import org.junit.*;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

public class ReadTsvFileTest {
    private ReadTsvFile readTsvFile;
    private Scanner scannerMock;
    @Before
    public void before() {
        scannerMock = Mockito.mock(Scanner.class);
        readTsvFile = new ReadTsvFile(scannerMock);
        System.out.println("Before");
    }

    @After
    public void after() {
        readTsvFile = null;
        System.out.println("after");
    }

    @Test
    public void testFillMap() {
        HashMap<String, SdAttribute> map = new HashMap<>();
        assertEquals(0, map.size());

        readTsvFile.fillMap(map, "hallo", "welt");

        assertEquals(1, map.size());
        assertTrue(map.containsKey("hallo"));

        SdAttribute sdAttribute = map.get("hallo");

//        SdAttribute expected = new SdAttribute("hallo", "welt");
//        assertEquals(expected,sdAttribute);

        assertEquals("hallo", sdAttribute.getId());
        assertEquals("welt", sdAttribute.getDescription());

    }

    @Test
    public void TestGetTsvFile() throws Exception {


        List<String> tsvFile = readTsvFile.getTsvFile();
        Path expectedPath = Paths.get(getClass().getClassLoader().getResource("co#sap_testIdentical.tsv").toURI());
//      Path expectedPath = Paths.get(getClass().getClassLoader().getResource("co#sap_testDifferent.tsv").toURI());
        List<String> expectedTsvFile = Files.readAllLines(expectedPath);

        assertEquals(expectedTsvFile, tsvFile);

    }

    @Test
    public void TestGetAttributeId() {
        Mockito.when(scannerMock.nextLine()).thenReturn("co#MON006");
        String expected = "co#MON006";
        String attribute = readTsvFile.getAttributeID();
        Mockito.verify(scannerMock).nextLine();

        assertEquals(expected, attribute);

    }
    @Test
    public void TestGetAttributeId_second() {
        Mockito.when(scannerMock.nextLine()).thenReturn("Apfelstrudel");
        String expected = "Apfelstrudel";
        String attribute = readTsvFile.getAttributeID();
        Mockito.verify(scannerMock).nextLine();

        assertEquals(expected, attribute);

    }

    @Test
    public void testSplitTsv() throws Exception {
        List<String> tsvFile = readTsvFile.getTsvFile();
        HashMap<String, SdAttribute> map = new HashMap<>();

        //checks if map is empty
        assertEquals(0, map.size());

        map = readTsvFile.splitTsv(tsvFile);

        //Checks if map has 955 entries
        assertEquals(955, map.size());
        assertEquals("co#MON006", map.get("co#MON006").getId());
        assertEquals("MONITORING TABTABLE HASHES", map.get("co#MON006").getDescription());

    }

    @Test
    public void foobar() {
        SdAttribute attr1 = new SdAttribute("a", "b");
        SdAttribute attr2 = new SdAttribute("a", "b");
        SdAttribute attr3 = attr1;

        System.out.println("attr1 = " + attr1);
        System.out.println("attr2 = " + attr2);
        System.out.println("attr3 = " + attr3);

        attr3.setDescription("hallo");

        System.out.println("description of attr1 = " + attr1.getDescription());
        System.out.println("description of attr2 = " + attr2.getDescription());
        System.out.println("description of attr3 = " + attr3.getDescription());
    }

}