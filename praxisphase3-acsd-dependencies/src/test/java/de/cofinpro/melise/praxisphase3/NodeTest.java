package de.cofinpro.melise.praxisphase3;

import org.junit.*;
import org.mockito.Mockito;

import java.lang.reflect.Array;
import java.util.*;

public class NodeTest {
    private Node node;
    private SdAttribute sdAttribute = new SdAttribute("hello", "world");

    @Before
    public void before() {
        //Vorbereitung
        node= new Node(sdAttribute);
    }

    @Test
    public void testGetValue() {
        SdAttribute sdAttribute = new SdAttribute("Pipi Langstrumpf", "Regenbogensocken");
        Node newNode= new Node(sdAttribute);


        SdAttribute value = newNode.getValue();

        Assert.assertEquals(sdAttribute, value);

    }

    @Test
    public void testGetChildren_NoNode() {

        Set<Node> children = node.getChildren();

        Assert.assertTrue(children.isEmpty());
    }

    @Test
    public void testGetChildren_HasNode() {
        SdAttribute sdAttribute = new SdAttribute("Pipi Langstrumpf", "Regenbogensocken");
        node.add(sdAttribute);

        Set<Node> children = node.getChildren();
        Object[] nodeArray = children.toArray();

        Assert.assertEquals(1,nodeArray.length);
        Assert.assertSame(((Node) nodeArray[0]).getValue(), sdAttribute);
    }

    @Test
    public void testGetChildren_HasManyNodes() {
        SdAttribute child0 = new SdAttribute("Batman", "Fledermaus");
        SdAttribute child1 = new SdAttribute("Superman", "Krypton");
        SdAttribute child2 = new SdAttribute("Das Sams", "Sommersprossen");

        Node child0Node = new Node(child0, node);
        Node child1Node = new Node(child1, node);
        Node child2Node = new Node(child2, node);


        node.add(child0);
        node.add(child1);
        node.add(child2);

        Set<Node> children = node.getChildren();

        Assert.assertEquals(3,children.size());
        Assert.assertTrue(children.contains(child0Node));
        Assert.assertTrue(children.contains(child1Node));
        Assert.assertTrue(children.contains(child2Node));

    }

    @Test
    public void testHasSpecificChild_NoSpecificChild() {
        // Fall: spezifisches Kind vorhanden

        //Vorbereitung
        SdAttribute searchedChild = new SdAttribute("Pipi Langstrumpf", "Regenbogensocken");

        //Durchführung
        boolean hasSpecificChild = node.hasSpecificChild(searchedChild);

        //Erwartetes Ergebnis
        Assert.assertFalse(hasSpecificChild);
    }

    @Test
    public void testHasSpecificChild_OneSpecificChild() {
        // Fall: spezifisches Kind vorhanden

        //Vorbereitung
        SdAttribute child0 = new SdAttribute("Pipi Langstrumpf", "Regenbogensocken");
        node.add(child0);

        //Durchführung
        SdAttribute searchedChild = new SdAttribute("Pipi Langstrumpf", "Regenbogensocken");
        boolean hasSpecificChild = node.hasSpecificChild(searchedChild);

        //Erwartetes Ergebnis
        Assert.assertTrue(hasSpecificChild);

    }

    @Test
    public void testHasSpecificChild_OneSpecificChildButNotSearchedOne() {
        // Fall: spezifisches Kind vorhanden

        //Vorbereitung
        SdAttribute child0 = new SdAttribute("Das Sams", "Sommersprossen");

        node.add(child0);

        //Durchführung
        SdAttribute searchedChild = new SdAttribute("Pipi Langstrumpf", "Regenbogensocken");
        boolean hasSpecificChild = node.hasSpecificChild(searchedChild);

        //Erwartetes Ergebnis
        Assert.assertFalse(hasSpecificChild);

    }

    @Test
    public void testHasSpecificChild_ManySpecificChildrenButNotSearchedOnes() {
        // Fall: spezifisches Kind vorhanden

        //Vorbereitung
        SdAttribute child0 = new SdAttribute("Batman", "Fledermaus");
        SdAttribute child1 = new SdAttribute("Superman", "Krypton");
        SdAttribute child2 = new SdAttribute("Das Sams", "Sommersprossen");

        node.add(child0);
        node.add(child1);
        node.add(child2);

        //Durchführung

        SdAttribute searchedChild = new SdAttribute("Pipi Langstrumpf", "Regenbogensocken");
        boolean hasSpecificChild = node.hasSpecificChild(searchedChild);

        //Erwartetes Ergebnis
        Assert.assertFalse(hasSpecificChild);

    }

    @Test
    public void testHasSpecificChild_ManySpecificChildrenSearchedOneFound() {
        // Fall: spezifisches Kind vorhanden

        //Vorbereitung
        SdAttribute child0 = new SdAttribute("Pipi Langstrumpf", "Regenbogensocken");
        SdAttribute child1 = new SdAttribute("Batman", "Fledermaus");
        SdAttribute child2 = new SdAttribute("Superman", "Krypton");
        SdAttribute child3 = new SdAttribute("Das Sams", "Sommersprossen");

        node.add(child0);
        node.add(child1);
        node.add(child2);
        node.add(child3);

        //Durchführung
        SdAttribute searchedChild = new SdAttribute("Pipi Langstrumpf", "Regenbogensocken");
        boolean hasSpecificChild = node.hasSpecificChild(searchedChild);

        //Erwartetes Ergebnis
        Assert.assertTrue(hasSpecificChild);

    }


    @Test
    public void testHasAnyChildren_NOChildren() {

        //Fall: keine Knoten

        //Durchführung
        boolean dependency = node.hasAnyChildren();

        //Erwartetes ergebnis
        Assert.assertFalse(dependency);
    }

    @Test
    public void testHasAnyChildren_OneChild() {

        //Fall: hat Knoten

        //Vorbereitung
        SdAttribute child1 = new SdAttribute("Pipi Langstrumpf", "Regenbogensocken");
        node.add(child1);

        //Durchführung
        boolean hasAnyChildren = node.hasAnyChildren();

        //Erwartetes Ergebnis
        Assert.assertTrue(hasAnyChildren);

    }

    @Test
    public void testHasAnyChildren_ManyChildren() {

        //Fall: mehr als ein Kind

        //Vorbereitung
        SdAttribute child1 = new SdAttribute("Pipi Langstrumpf", "Regenbogensocken");
        node.add(child1);

        SdAttribute child2 = new SdAttribute("Das Sams", "Sommersprossen");
        node.add(child2);

        //Durchführung
        boolean hasAnyChildren = node.hasAnyChildren();

        //Erwartetes Ergebnis
        Assert.assertTrue(hasAnyChildren);

    }
}