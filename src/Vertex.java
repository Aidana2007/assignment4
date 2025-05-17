package src;

import java.util.HashMap;
import java.util.Map;

// Represents a graph vertex with generic data type
public class Vertex<V> {
    private V data; // Data stored in the vertex
    private Map<Vertex<V>, Double> adjacentVertices; // Adjacent vertices and edge weights

    // Constructor to initialize vertex data
    public Vertex(V data) {
        this.data = data;
        this.adjacentVertices = new HashMap<>();
    }

    // Adds an adjacent vertex with weight
    public void addAdjacentVertex(Vertex<V> destination, double weight) {
        adjacentVertices.put(destination, weight);
    }

    // Returns adjacent vertices and their weights
    public Map<Vertex<V>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }

    // Returns the vertex data
    public V getData() {
        return data;
    }

    // Returns string representation of vertex data
    @Override
    public String toString() {
        return data.toString();
    }
}
