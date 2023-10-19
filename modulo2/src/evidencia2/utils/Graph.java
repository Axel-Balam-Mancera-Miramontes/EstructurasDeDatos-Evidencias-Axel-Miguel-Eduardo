package evidencia2.utils;

import java.util.Set;
import java.util.HashSet;
import java.util.Optional;

/**
 * Represents a weighted directed graph.
 */
public class Graph {
    private Set<GraphNode> nodes;
    private GraphNode root;

    /**
     * Initializes an empty graph.
     */
    public Graph() {
        root = new GraphNode("Animal nulo");
        root.setNextAnimalFeature("Cuernos");

        nodes = new HashSet<>();
        addEdgeYes(root, new GraphNode("Vaca"));
        addEdgeNo(root, new GraphNode("Perro"));
    }

    /**
     * Adds a node to the graph if it doesn't already exist.
     *
     * @param newNode The node to be added.
     */
    public void addNode(GraphNode newNode) {
        if (newNode != null && !nodes.contains(newNode)) {
            nodes.add(newNode);
        }
    }

    /**
     * Adds an edge between two nodes with an associated weight.
     */

    //Add yes neighbour.
    public void addEdgeYes(GraphNode from, GraphNode to) {
        if (from != null && to != null) {
            from.addNeighbourYes(to);
            addNode(from);
            addNode(to);
        }
    }

    //Add no neighbour.
    public void addEdgeNo(GraphNode from, GraphNode to) {
        if (from != null && to != null) {
            from.addNeighbourNo(to);
            addNode(from);
            addNode(to);
        }
    }

    //Class' getters.

    /**
     * Gets the set of nodes in the graph.
     *
     * @return The set of nodes.
     */
    public GraphNode getRoot() {
        return root;
    }

    /**
     * Gets the set of nodes in the graph.
     *
     * @return The set of nodes.
     */
    public Set<GraphNode> getNodes() {
        return nodes;
    }

}
