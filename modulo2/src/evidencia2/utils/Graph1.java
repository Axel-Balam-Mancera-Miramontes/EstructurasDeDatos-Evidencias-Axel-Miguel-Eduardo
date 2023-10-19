package evidencia2.utils;

import java.util.Set;
import java.util.HashSet;

/**
 * Represents a weighted directed graph.
 */
public class Graph1 {
    private Set<GraphNode1> nodes;
    private GraphNode1 root;

    /**
     * Initializes an empty graph.
     */
    public Graph1() {
        root = new GraphNode1("Animal nulo");
        root.setNextAnimalFeature("Cuernos");

        nodes = new HashSet<>();
        addEdgeYes(root, new GraphNode1("Vaca"));
        addEdgeNo(root, new GraphNode1("Perro"));
    }

    /**
     * Adds a node to the graph if it doesn't already exist.
     *
     * @param newNode The node to be added.
     */
    public void addNode(GraphNode1 newNode) {
        if (newNode != null && !nodes.contains(newNode)) {
            nodes.add(newNode);
        }
    }

    /**
     * Adds an edge between two nodes with an associated weight.
     */

    //Add yes neighbour.
    public void addEdgeYes(GraphNode1 from, GraphNode1 to) {
        if (from != null && to != null) {
            from.addNeighbourYes(to);
            addNode(from);
            addNode(to);
        }
    }

    //Add no neighbour.
    public void addEdgeNo(GraphNode1 from, GraphNode1 to) {
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
    public GraphNode1 getRoot() {
        return root;
    }

    /**
     * Gets the set of nodes in the graph.
     *
     * @return The set of nodes.
     */
    public Set<GraphNode1> getNodes() {
        return nodes;
    }

}
