package src;

// Represents a directed edge between two vertices
public class Edge<V> {
    private Vertex<V> source; // Start vertex
    private Vertex<V> destination; // End vertex
    private double weight; // Edge weight

    // Constructor to initialize edge
    public Edge(Vertex<V> source, Vertex<V> destination, double weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    // Returns the source vertex
    public Vertex<V> getSource() {
        return source;
    }

    // Returns the destination vertex
    public Vertex<V> getDestination() {
        return destination;
    }

    // Returns the edge weight
    public double getWeight() {
        return weight;
    }
}

