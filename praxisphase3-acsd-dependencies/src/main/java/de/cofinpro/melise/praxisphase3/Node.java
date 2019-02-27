package de.cofinpro.melise.praxisphase3;
/** Klasse speichert  die Baumstruktur der Attribute */
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

    public Node ( Node source){
        this.value = source.value;
        this.parent = source.parent;
        this.children = source.children;
    }

    //Methods

    public Node getParent() {

        return parent;
    }

    public SdAttribute getValue() {

        return value;
    }

    public Set<Node> getChildren() {

        return new HashSet<>(children);
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

        Node copyOfChildNode = new Node(childNode);
        copyOfChildNode.parent = this;
        children.add(copyOfChildNode);
    }

    public String toString() {
        return toString(false);
    }

    public String toString(boolean onlyValueId) {
        if (onlyValueId) {
            return this.value.getId();
        } else {
            return "Node{" +
                    "value=" + value +
                    ", parent=" + (parent == null ? null : parent.toString(true)) +
                    ", children= " + children + '}';
        }
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