package de.cofinpro.melise.praxisphase3;

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