package pl.put.poznan.analyzer.commons;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class is used to manage a single node
 */
public class Node {

    private int id;
    private String name;
    private NodeType nodeType;
    private List<Connection> outgoing;
    private List<Connection> incoming;


    // setters getters


    /**
     * Class constructor for nodes with connections
     * @param id node id
     * @param name optional description of the node
     * @param nodeType node type can be ENTRY, EXIT or REGULAR
     * @param outgoing list of outgoing connections from the node
     * @param incoming list of incoming connections to the node
     */
    public Node(Integer id, String name, NodeType nodeType, List<Connection> outgoing, List<Connection> incoming) {
        this.id = id;
        this.name = name;
        this.nodeType = nodeType;
        this.outgoing = outgoing;
        this.incoming = incoming;
    }

    /**
     * Class constructor for nodes without connections
     * @param id node id
     * @param name optional description of the node
     * @param nodeType node type can be ENTRY, EXIT or REGULAR
     */
    public Node(Integer id, String name, NodeType nodeType) {
        this.id = id;
        this.name = name;
        this.nodeType = nodeType;
        this.outgoing = new ArrayList<>();
        this.incoming = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    /**
     * Empty class constructor
     */
    public Node() {
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
