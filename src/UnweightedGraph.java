package src;

import java.util.*;

// Custom unweighted graph class
public class UnweightedGraph<Vertex> {
    private final boolean isUndirected; // true if the graph is undirected
    private final Map<Vertex, List<Vertex>> adjMap = new HashMap<>(); // adjacency list

    // Default constructor (creates an undirected graph)
    public UnweightedGraph() {
        this(true);
    }

    // Constructor to choose directed or undirected graph
    public UnweightedGraph(boolean isUndirected) {
        this.isUndirected = isUndirected;
    }

    // Adds a new vertex if it's not already in the graph
    public void addVertex(Vertex vertex) {
        if (!hasVertex(vertex)) {
            adjMap.put(vertex, new LinkedList<>()); // use LinkedList as in teacher's version
        }
    }

    // Adds an edge between two vertices (no self-loops or duplicate edges)
    public void addEdge(Vertex from, Vertex to) {
        if (!hasVertex(from)) addVertex(from);
        if (!hasVertex(to)) addVertex(to);

        if (hasEdge(from, to) || from.equals(to)) return; // skip loops and duplicates

        adjMap.get(from).add(to);

        if (isUndirected) {
            adjMap.get(to).add(from);
        }
    }

    // Returns the number of vertices in the graph
    public int getVerticesCount() {
        return adjMap.size();
    }

    // Returns the total number of edges in the graph
    public int getEdgesCount() {
        int count = 0;
        for (List<Vertex> neighbors : adjMap.values()) {
            count += neighbors.size();
        }

        if (isUndirected) {
            count /= 2; // each undirected edge is counted twice
        }

        return count;
    }

    // Checks if a vertex exists in the graph
    public boolean hasVertex(Vertex v) {
        return adjMap.containsKey(v);
    }

    // Checks if there is an edge between two vertices
    public boolean hasEdge(Vertex from, Vertex to) {
        if (!hasVertex(from)) return false;
        return adjMap.get(from).contains(to);
    }

    // Returns the adjacency list of a vertex
    public List<Vertex> adjacencyList(Vertex v) {
        return adjMap.getOrDefault(v, null);
    }
}
