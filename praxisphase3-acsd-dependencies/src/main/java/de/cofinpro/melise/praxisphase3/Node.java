package de.cofinpro.melise.praxisphase3;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.*;

public class Node {

    //Variables
    private SdAttribute value;
    private Node parent = null;
    private Set<Node> children = new HashSet<>();

    //Constructor
    public Node(SdAttribute sdAttribute) {

        this.value = sdAttribute;
    }

    public Node(SdAttribute sdAttribute, Node parent) {

        this.value = sdAttribute;
        this.parent = parent;

    }

    //Methods

    public SdAttribute getValue() {

        return value;
    }

    public Set<Node> getChildren() {

        return children;
    }

    public boolean hasSpecificChild(SdAttribute sdAttribute) {

        Node childNode = new Node(sdAttribute, this);
        return children.contains(childNode);
    }

    public boolean hasAnyChildren() {

        return !children.isEmpty();
    }

    public void add(SdAttribute sdAttribute) {

        Node childNode = new Node(sdAttribute, this);
        children.add(childNode);
    }

    public void add(Node childNode) {

        children.add(childNode);
    }

    //String Repräsentation des Baums
//    @Override
//    public String toString() {
//        //rekursiv
//        return
//                "Node{" +
//                        "value=" + value +
//                        ", parent=" + (parent != null && parent.getValue() != null ? parent.getValue().getId() : null) +
//                        ", children= " + children + '}';
//
//    }
//
//    public String toString(boolean onlyValueId) {
//        if (onlyValueId) {
//            return
//                    "Node{" +
//                            "value=" + value +
//                            ", parent=" + parent +
//                            ", children= " + children + '}';
//        } else {
//            return "Node{" +
//                    "value=" + value +
//                    ", parent=" + parent + '}';
//
//        }
//
//    }

    public String toString2() {
        return toString2(false);
    }

    public String toString2(boolean onlyValueId) {
        if (onlyValueId) {
            return this.value.getId();
        } else {
            return "Node{" +
                    "value=" + value +
                    ", parent=" + (parent == null ? null : parent.toString2(true)) +
                    ", children= " + children + '}';
        }
    }

    //converting to Json with GSON
//    public String toJson() {
//
//        return toJson(false);
//
//    }
    public String toJson() {

        Gson gson = new Gson();
        StringBuilder jsonStringBuilder = new StringBuilder();
        jsonStringBuilder.append("{");
        jsonStringBuilder.append("\"name\": ");
        jsonStringBuilder.append(gson.toJson(this.value.getId()));
        jsonStringBuilder.append(", \"parent\": ");
        jsonStringBuilder.append(gson.toJson(this.parent == null ? null : this.parent));
        jsonStringBuilder.append(", \"children\": ");
        jsonStringBuilder.append(gson.toJson(this.children));
        jsonStringBuilder.append("}");

        return jsonStringBuilder.toString();
//
//        if(onlyValueId){
//            return this.value.getId();
//        }else{
//
//        }



    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (!value.equals(node.value)) return false;
        return parent != null ? parent.equals(node.parent) : node.parent == null;
    }

    @Override
    public int hashCode() {
        int result = value.hashCode();
        result = 31 * result + (parent != null ? parent.hashCode() : 0);
        return result;
    }
}