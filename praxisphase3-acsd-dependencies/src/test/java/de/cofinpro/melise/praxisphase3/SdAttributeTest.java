package de.cofinpro.melise.praxisphase3;

import org.junit.Test;

import static org.junit.Assert.*;

public class SdAttributeTest {
    private String id = "#co300";
    private String description = "Attribute for BliBlaBlub";

    @Test
    public void attributeTest() {
        SdAttribute attribute = new SdAttribute(id, description);
        String attributeId = attribute.getId();
        String attributeDescription = attribute.getDescription();
        assertEquals(id, attributeId);
        assertEquals(description, attributeDescription);
    }


}