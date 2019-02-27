package de.cofinpro.melise.praxisphase3;
/** Dient zur Umformung des Nodes to Json  */
import com.google.gson.Gson;
import java.util.HashSet;
import java.util.Set;

public class JsonNode {
    private String name;
    private String parent;
    private Set<JsonNode> children = new HashSet<>();

    public JsonNode(Node node) {
        JsonNode fromNode = fromNode(node);
        name = fromNode.name;
        parent = fromNode.parent;
        children = fromNode.children;
    }

    private JsonNode() {

    }

    public static JsonNode fromNode(Node node) {
        JsonNode jsonNode = new JsonNode();
        jsonNode.name = node.getValue() == null ? "null" : node.getValue().getId();
        jsonNode.parent = node.getParent() == null || node.getParent().getValue() == null ? "null" : node.getParent().getValue().getId();

        if (node.hasAnyChildren()) {
            for (Node child : node.getChildren()) {
                jsonNode.children.add(fromNode(child));
            }
        }
        return jsonNode;
    }

    public String toJson() {
        Gson gson = new Gson();

        return gson.toJson(this);

    }

}
