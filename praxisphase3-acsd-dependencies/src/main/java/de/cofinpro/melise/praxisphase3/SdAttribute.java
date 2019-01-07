/*
 * POJO for Stammdaten Attribute
 */
package de.cofinpro.melise.praxisphase3;

import java.util.Objects;

public class SdAttribute {

    private String id;
    private String description;


    public SdAttribute(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getId() {

        return id;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    //gebraucht um zu schauen ob Objekte identisch/gleich sind -> geht auch mit properties (getId, getDescription)
    //wenn id oderdescription == null --> NullPointerexception
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SdAttribute that = (SdAttribute) o;
        return id.equals(that.id) &&
                description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }

    /*public String toString() {
        return "SdAttribute{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                '}';
    }*/
}
