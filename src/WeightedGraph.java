package src;

import java.util.*;

// A simple weighted graph using adjacency list
public class WeightedGraph<V> {
    private Map<Vertex<V>, List<Edge<V>>> map = new HashMap<>();
    // adjacency list with edges

    public WeightedGraph() {
        this.map = new HashMap<>();
    }

    // Add a new vertex if it's not already in the graph
    public void addVertex(Vertex<V> vertex) {
        map.putIfAbsent(vertex, new ArrayList<>());
    }

    // Add a directed edge with weight from source to destination
    public void addEdge(Vertex<V> source, Vertex<V> dest, double weight) {
        if (!map.containsKey(source)) {
            addVertex(source);
        }
        if (!map.containsKey(dest)) {
            addVertex(dest);
        }

        map.get(source).add(new Edge<>(source, dest, weight));
    }

    // Get all vertices in the graph
    public Set<Vertex<V>> getVertices() {
        return map.keySet();
    }

    // Get neighbors of a vertex (just destination vertices)
    public List<Vertex<V>> getNeighbors(Vertex<V> vertex) {
        List<Vertex<V>> neighbors = new ArrayList<>();
        List<Edge<V>> edges = map.get(vertex);
        if (edges != null) {
            for (Edge<V> edge : edges) {
                neighbors.add((Vertex<V>) edge.getDestination());
            }
        }
        return neighbors;
    }

    // Get adjacency list (needed for Dijkstra/BFS)
    public List<Vertex<V>> adjacencyList(Vertex<V> vertex) {
        return getNeighbors(vertex); // reuse getNeighbors logic
    }

    // Get edges connected to a vertex (needed for Dijkstra)
    public List<Edge<V>> getEdges(Vertex<V> vertex) {
        return map.getOrDefault(vertex, new ArrayList<>());
    }

    // Optional: simple BFS from a starting vertex
    public void bfs(Vertex<V> start) {
        Set<Vertex<V>> visited = new HashSet<>();
        Queue<Vertex<V>> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();
            System.out.println(current); // print current node

            for (Vertex<V> neighbor : getNeighbors(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }
}


