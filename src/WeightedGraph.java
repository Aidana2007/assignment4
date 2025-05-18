package src;

import java.util.*;

// Represents a weighted graph with vertices
public class WeightedGraph<V> {
    private Map<Vertex<V>, List<Vertex<V>>> map; // Adjacency list

    // Constructor to initialize the graph
    public WeightedGraph() {
        this.map = new HashMap<>();
    }

    // Adds a new vertex to the graph
    public void addVertex(Vertex<V> vertex) {
        map.putIfAbsent(vertex, new ArrayList<>());
    }

    // Adds a directed edge with weight between two vertices
    public void addEdge(Vertex<V> source, Vertex<V> dest, double weight) {
        source.addAdjacentVertex(dest, weight); // update source vertex
        map.get(source).add(dest); // update adjacency list
    }

    // Returns all vertices in the graph
    public Set<Vertex<V>> getVertices() {
        return map.keySet();
    }

    // Returns neighbors of a vertex
    public List<Vertex<V>> getNeighbors(Vertex<V> vertex) {
        return map.get(vertex);
    }
}

