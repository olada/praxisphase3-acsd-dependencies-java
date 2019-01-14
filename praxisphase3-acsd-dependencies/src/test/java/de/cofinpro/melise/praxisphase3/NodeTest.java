package de.cofinpro.melise.praxisphase3;

import org.junit.*;
import java.util.*;
import static org.junit.Assert.*;

public class NodeTest {
    private Node helloNode;
    private SdAttribute helloSdAttribute = new SdAttribute("hello", "world");

    @Before
    public void before() {
        //Vorbereitung
        helloNode = new Node(helloSdAttribute);
    }


    @Test
    public void testToString() {

        SdAttribute pipiSdAttribute = new SdAttribute("Pipi Langstrumpf", "Regenbogensocken");

        helloNode.add(pipiSdAttribute);

        String toString = helloNode.toString();

        assertTrue(toString.contains(pipiSdAttribute.getId()));

    }


    @Test
    public void testGetValue() {
        SdAttribute sdAttribute = new SdAttribute("Pipi Langstrumpf", "Regenbogensocken");
        Node newNode= new Node(sdAttribute);
        SdAttribute value = newNode.getValue();

        assertEquals(sdAttribute, value);
    }

    @Test
    public void testGetChildren_NoNode() {

        Set<Node> children = helloNode.getChildren();

        assertTrue(children.isEmpty());
    }

    @Test
    public void testGetChildren_HasNode() {
        SdAttribute pipiChild = new SdAttribute("Pipi Langstrumpf", "Regenbogensocken");
        helloNode.add(pipiChild);

        Set<Node> children = helloNode.getChildren();
        Object[] nodeArray = children.toArray();

        assertEquals(1,nodeArray.length);
        assertSame(((Node) nodeArray[0]).getValue(), pipiChild);
    }

    @Test
    public void testGetChildren_HasManyNodes() {
        SdAttribute child0 = new SdAttribute("Batman", "Fledermaus");
        SdAttribute child1 = new SdAttribute("Superman", "Krypton");
        SdAttribute child2 = new SdAttribute("Das Sams", "Sommersprossen");

        Node child0Node = new Node(child0, helloNode);
        Node child1Node = new Node(child1, helloNode);
        Node child2Node = new Node(child2, helloNode);


        helloNode.add(child0Node);
        helloNode.add(child1Node);
        helloNode.add(child2Node);

        Set<Node> children = helloNode.getChildren();

        assertEquals(3,children.size());
        assertTrue(children.contains(child0Node));
        assertTrue(children.contains(child1Node));
        assertTrue(children.contains(child2Node));

    }

    @Test
    public void testHasSpecificChild_NoSpecificChild() {
        // Fall: spezifisches Kind vorhanden

        //Vorbereitung
        SdAttribute searchedChild = new SdAttribute("Pipi Langstrumpf", "Regenbogensocken");

        //Durchführung
        boolean hasSpecificChild = helloNode.hasSpecificChild(searchedChild);

        //Erwartetes Ergebnis
        Assert.assertFalse(hasSpecificChild);
    }

    @Test
    public void testHasSpecificChild_OneSpecificChild() {
        // Fall: spezifisches Kind vorhanden

        //Vorbereitung
        SdAttribute child0 = new SdAttribute("Pipi Langstrumpf", "Regenbogensocken");

        helloNode.add(child0);

        //Durchführung
        SdAttribute searchedChild = new SdAttribute("Pipi Langstrumpf", "Regenbogensocken");
        boolean hasSpecificChild = helloNode.hasSpecificChild(searchedChild);

        //Erwartetes Ergebnis
        assertTrue(hasSpecificChild);

    }

    @Test
    public void testHasSpecificChild_OneSpecificChildButNotSearchedOne() {
        // Fall: spezifisches Kind vorhanden

        //Vorbereitung
        SdAttribute child0 = new SdAttribute("Das Sams", "Sommersprossen");
        Node samsNode = new Node(child0);
        helloNode.add(samsNode);

        //Durchführung
        SdAttribute searchedChild = new SdAttribute("Pipi Langstrumpf", "Regenbogensocken");
        boolean hasSpecificChild = helloNode.hasSpecificChild(searchedChild);

        //Erwartetes Ergebnis
        assertFalse(hasSpecificChild);

    }

    @Test
    public void testHasSpecificChild_ManySpecificChildrenButNotSearchedOnes() {
        // Fall: spezifisches Kind vorhanden

        //Vorbereitung
        SdAttribute child0 = new SdAttribute("Batman", "Fledermaus");
        SdAttribute child1 = new SdAttribute("Superman", "Krypton");
        SdAttribute child2 = new SdAttribute("Das Sams", "Sommersprossen");
        Node batmanNode = new Node(child0);
        Node supermanNode = new Node(child1);
        Node samsNode = new Node(child2);
        helloNode.add(batmanNode);
        helloNode.add(supermanNode);
        helloNode.add(samsNode);


        //Durchführung

        SdAttribute searchedChild = new SdAttribute("Pipi Langstrumpf", "Regenbogensocken");
        boolean hasSpecificChild = helloNode.hasSpecificChild(searchedChild);

        //Erwartetes Ergebnis
        assertFalse(hasSpecificChild);

    }

    @Test
    public void testHasSpecificChild_ManySpecificChildrenSearchedOneFound() {
        // Fall: spezifisches Kind vorhanden

        //Vorbereitung
        SdAttribute child0 = new SdAttribute("Pipi Langstrumpf", "Regenbogensocken");
        SdAttribute child1 = new SdAttribute("Batman", "Fledermaus");
        SdAttribute child2 = new SdAttribute("Superman", "Krypton");
        SdAttribute child3 = new SdAttribute("Das Sams", "Sommersprossen");

        helloNode.add(child0);
        helloNode.add(child1);
        helloNode.add(child2);
        helloNode.add(child3);

        //Durchführung
        SdAttribute searchedChild = new SdAttribute("Pipi Langstrumpf", "Regenbogensocken");
        boolean hasSpecificChild = helloNode.hasSpecificChild(searchedChild);

        //Erwartetes Ergebnis
        assertTrue(hasSpecificChild);

    }


    @Test
    public void testHasAnyChildren_NOChildren() {

        //Fall: keine Knoten

        //Durchführung
        boolean dependency = helloNode.hasAnyChildren();

        //Erwartetes ergebnis
        assertFalse(dependency);
    }

    @Test
    public void testHasAnyChildren_OneChild() {

        //Fall: hat Knoten

        //Vorbereitung
        SdAttribute child1 = new SdAttribute("Pipi Langstrumpf", "Regenbogensocken");
        Node pipiNode = new Node(child1);
        helloNode.add(pipiNode);


        //Durchführung
        boolean hasAnyChildren = helloNode.hasAnyChildren();

        //Erwartetes Ergebnis
        assertTrue(hasAnyChildren);

    }

    @Test
    public void testHasAnyChildren_ManyChildren() {

        //Fall: mehr als ein Kind

        //Vorbereitung
        SdAttribute child1 = new SdAttribute("Pipi Langstrumpf", "Regenbogensocken");
        Node pipiNode = new Node(child1);
        helloNode.add(pipiNode);

        SdAttribute child2 = new SdAttribute("Das Sams", "Sommersprossen");
        Node samsNode = new Node(child2);
        helloNode.add(samsNode);

        //Durchführung
        boolean hasAnyChildren = helloNode.hasAnyChildren();

        //Erwartetes Ergebnis
        assertTrue(hasAnyChildren);

    }
}