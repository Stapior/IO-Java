package pl.put.poznan.analyzer.commons;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Node {

    private Integer id;
    private String name;
    private NodeType nodeType;
    private List<Connection> outgoing;
    private List<Connection> incoming;


    // setters getters


    public Node(Integer id, String name, NodeType nodeType, List<Connection> outgoing, List<Connection> incoming) {
        this.id = id;
        this.name = name;
        this.nodeType = nodeType;
        this.outgoing = outgoing;
        this.incoming = incoming;
    }

    public Node(Integer id, String name, NodeType nodeType) {
        this.id = id;
        this.name = name;
        this.nodeType = nodeType;
        this.outgoing = new ArrayList<>();
        this.incoming = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NodeType getNodeType() {
        return nodeType;
    }

    public void setNodeType(NodeType nodeType) {
        this.nodeType = nodeType;
    }

    public List<Connection> getOutgoing() {
        return outgoing;
    }

    public void setOutgoing(List<Connection> outgoing) {
        this.outgoing = outgoing;
    }

    public List<Connection> getIncoming() {
        return incoming;
    }

    public void setIncoming(List<Connection> incoming) {
        this.incoming = incoming;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(id, node.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, nodeType, outgoing, incoming);
    }

    @Override
    public String toString() {
        return "Node{" +
                "id: " + id +
                ", name: '" + name + '\'' +
                ", nodeType: " + nodeType +
                ", outgoing: " + outgoing +
                ", incoming: " + incoming +
                '}';
    }


}