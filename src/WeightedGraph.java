package src;

import java.util.*;

// Represents a weighted graph with vertices
public class WeightedGraph<V> {
    private Map<Vertex<V>, List<Vertex<V>>> map; // adjacency list

    // Constructor to initialize the graph
    public WeightedGraph() {
        this.map = new HashMap<>();
    }

    // Adds a new vertex to the graph
    public void addVertex(Vertex<V> vertex) {
        map.putIfAbsent(vertex, new ArrayList<>()); // add if not present
    }

    // Adds a directed edge with weight between two vertices
    public void addEdge(Vertex<V> source, Vertex<V> dest, double weight) {
        source.addAdjacentVertex(dest, weight); // store weight in vertex
        map.get(source).add(dest); // update adjacency list
    }

    // Returns all vertices in the graph
    public Set<Vertex<V>> getVertices() {
        return map.keySet(); // return all keys
    }

    // Returns neighbors of a vertex
    public List<Vertex<V>> getNeighbors(Vertex<V> vertex) {
        return map.get(vertex); // return neighbor list
    }

    // Performs Breadth-First Search starting from a given vertex
    public void bfs(Vertex<V> start) {
        Set<Vertex<V>> visited = new HashSet<>(); // visited tracker
        Queue<Vertex<V>> queue = new LinkedList<>(); // queue for BFS

        visited.add(start); // mark start as visited
        queue.add(start); // enqueue start

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll(); // dequeue vertex
            System.out.println(current); // print visited vertex

            List<Vertex<V>> neighbors = map.get(current); // get neighbors
            if (neighbors != null) {
                for (Vertex<V> neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor); // mark visited
                        queue.add(neighbor); // enqueue neighbor
                    }
                }
            }
        }
    }
}


