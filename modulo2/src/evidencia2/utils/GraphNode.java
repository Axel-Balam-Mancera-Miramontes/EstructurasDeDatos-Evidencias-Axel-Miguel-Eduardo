package evidencia2.utils;

import java.util.*;

/**
 * Represents a node in a graph.
 */
public class GraphNode {
    /**
     * Node's data
     */
    private String animal;
    private String nextAnimalFeature;
    private GraphNode neighbourYes;
    private GraphNode neighbourNo;

    /**
     * Constructs a new node with the specified data.
     *
     * @param animal The data to be stored in the node.
     */
    public GraphNode(String animal) {
        setAnimal(animal);
        setNextAnimalFeature("Característica del siguinete animal no definida.");
    }

    //Class' setters.

    public void setAnimal(String animal){
        this.animal = animal;
    };

    public void setNextAnimalFeature(String nextAnimalFeature){
        this.nextAnimalFeature = nextAnimalFeature;
    };

    //Class' getters.

    public String getAnimal(){
        return animal;
    }

    /**
     * Gets the data stored in the node.
     *
     * @return The data stored in the node.
     */
    public String getNextAnimalFeature() {
        return nextAnimalFeature;
    }

    /**
     * Adds an adjacent node with an associated edge weight.
     */

    // Add left nieghbour.
    public void addNeighbourYes(GraphNode neighbourYes){
        this.neighbourYes = neighbourYes;
    }

    // Add right nieghbour.
    public void addNeighbourNo(GraphNode neighbourNo){
        this.neighbourNo = neighbourNo;
    }

    /**
     * Get Yes and No neighbor
     */

    //Get nieghbour yes.
    public GraphNode getNeighbourYes(){
        return neighbourYes;
    }

    //Get nieghbour no.
    public GraphNode getNeighbourNo(){
        return neighbourNo;
    }

    /**
     * Gets a map of neighboring nodes and their associated edge weights.
     *
     * @return A map of adjacent nodes and their edge weights.
     */
    public ArrayList<GraphNode> getNeighbours() {
        ArrayList<GraphNode> neighbours = new ArrayList<>();
        GraphNode neighbour;

        neighbour= this.neighbourYes;
        if(neighbour != null){
            neighbours.add(neighbour);
        }

        neighbour= this.neighbourNo;
        if(neighbour != null){
            neighbours.add(neighbour);
        }

        return neighbours;
    }

    //Overwriting Object class' methods.

    @Override
    public String toString() {
        String strOut = "Nodo: " + this.getAnimal();

        for (GraphNode entry : this.getNeighbours()) {
            if(entry == null){
                strOut += "\n\tVecino: ---";
            }
            else{
                strOut += "\n\tVecino: " + entry.getAnimal();
            }
        }

        return strOut;
    }

    /**
     * Overrides the equals method to compare nodes based on their data values.
     *
     * @param o The node to compare with.
     * @return True if the nodes have the same data values, otherwise false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphNode node = (GraphNode) o;
        return Objects.equals(animal, node.animal);
    }

    /**
     * Overrides the hashCode method to generate a hash code based on the node's data value.
     *
     * @return The hash code calculated based on the data value.
     */
    @Override
    public int hashCode() {
        return Objects.hash(animal);
    }
}
