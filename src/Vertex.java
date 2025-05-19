package src;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

    public V getValue() {
        return data;
    }

    // Returns string representation of vertex data
    @Override
    public String toString() {
        return data.toString();
    }

    // Override equals to compare vertices based on data
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Vertex<?> vertex)) return false;
        return Objects.equals(data, vertex.data);
    }

    // Override hashCode to be consistent with equals
    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}

