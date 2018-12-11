package de.cofinpro.melise.praxisphase3;

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

    @Override
    public String toString() {
        return "SdAttribute{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
