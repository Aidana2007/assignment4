package src;

import java.util.*;

// Custom unweighted graph implementation
public class UnweightedGraph<Vertex> {
    private final boolean isUndirected;
    private final Map<Vertex, List<Vertex>> adjMap = new HashMap<>();

    // Default constructor (undirected graph)
    public UnweightedGraph() {
        this(true);
    }

    // Constructor with graph direction flag
    public UnweightedGraph(boolean isUndirected) {
        this.isUndirected = isUndirected;
    }

    // Adds a vertex if it doesn't exist
    public void addVertex(Vertex vertex) {
        adjMap.putIfAbsent(vertex, new ArrayList<>());
    }

    // Adds an edge between two vertices
    public void addEdge(Vertex from, Vertex to) {
        if (!adjMap.containsKey(from)) addVertex(from);
        if (!adjMap.containsKey(to)) addVertex(to);

        if (from.equals(to) || adjMap.get(from).contains(to)) return; // avoid loops/duplicates

        adjMap.get(from).add(to);

        if (isUndirected) {
            adjMap.get(to).add(from);
        }
    }
}