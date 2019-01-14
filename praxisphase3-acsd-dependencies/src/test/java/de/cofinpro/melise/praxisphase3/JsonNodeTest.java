package de.cofinpro.melise.praxisphase3;

import org.junit.Test;

import static org.junit.Assert.*;

public class JsonNodeTest {

    @Test
    public void testFromNodeTest(){

        SdAttribute attributBeispiel = new SdAttribute("hello", "world");
        Node node = new Node(attributBeispiel);
        SdAttribute pipiAttribut = new SdAttribute( "pipi", "Langstrumpf");
//        SdAttribute samsAttribut = new SdAttribute( "sams", "sommersprosse");

        node.add(pipiAttribut);
//        node.add(samsAttribut);
        JsonNode jsonNode = new JsonNode(node);

        String fromJson = jsonNode.toJson();

        assertTrue(fromJson.contains(pipiAttribut.getId()));
//        assertTrue(fromJson.contains(samsAttribut.getId()));


    }

}