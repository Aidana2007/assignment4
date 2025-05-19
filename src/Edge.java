package src;

import java.util.Objects;

// Represents a connection between two vertices in the graph
public class Edge<V> {
    private Vertex<V> source;         // where the edge starts
    private Vertex<V> destination;    // where the edge ends
    private double weight;            // how heavy the edge is

    // Constructor for weighted edge
    public Edge(Vertex<V> source, Vertex<V> destination, double weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    // Constructor without weight (default weight = 1.0)
    public Edge(Vertex<V> source, Vertex<V> destination) {
        this.source = source;
        this.destination = destination;
        this.weight = 1.0; // default value if not specified
    }

    // Getter for source
    public Vertex<V> getSource() {
        return source;
    }

    // Setter for source
    public void setSource(Vertex<V> source) {
        this.source = source;
    }

    // Getter for destination
    public Vertex<V> getDestination() {
        return destination;
    }

    // Setter for destination
    public void setDestination(Vertex<V> destination) {
        this.destination = destination;
    }

    // Getter for weight
    public double getWeight() {
        return weight;
    }

    // Setter for weight
    public void setWeight(double weight) {
        this.weight = weight;
    }

    // Used to check if two edges are equal (ignores weight)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // same reference

        if (obj == null || getClass() != obj.getClass()) return false;

        Edge<?> other = (Edge<?>) obj;

        return Objects.equals(source, other.source) &&
                Objects.equals(destination, other.destination);
    }

    // Optional: Helps in printing the edge (for debugging)
    @Override
    public String toString() {
        return source + " -> " + destination + " (" + weight + ")";
    }
}

