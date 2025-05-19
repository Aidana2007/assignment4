package src;

import java.util.*;

public class WeightedGraph<V> {
    private boolean undirected;
    private Map<Vertex<V>, List<Edge<V>>> map;

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
        this.map = new HashMap<>();
    }

    public void addVertex(Vertex<V> vertex) {
        map.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(V sourceData, V destData, double weight) {
        Vertex<V> source = new Vertex<>(sourceData);
        Vertex<V> dest = new Vertex<>(destData);

        if (!hasVertex(source)) {
            addVertex(source);
        }
        if (!hasVertex(dest)) {
            addVertex(dest);
        }

        if (hasEdge(source, dest) || source.equals(dest)) {
            return;
        }

        map.get(source).add(new Edge<>(source, dest, weight));

        if (undirected) {
            map.get(dest).add(new Edge<>(dest, source, weight));
        }
    }

    public boolean hasVertex(Vertex<V> v) {
        return map.containsKey(v);
    }

    public boolean hasEdge(Vertex<V> source, Vertex<V> dest) {
        List<Edge<V>> edges = map.get(source);
        if (edges == null) return false;

        for (Edge<V> edge : edges) {
            if (edge.getDestination().equals(dest)) {
                return true;
            }
        }
        return false;
    }

    public Set<Vertex<V>> getVertices() {
        return map.keySet();
    }

    public List<Vertex> adjacencyList(Vertex v) {
        if (!hasVertex(v)) return null;

        List<Vertex> vertices = new LinkedList<>();
        for (Edge<V> e : map.get(v)) {
            vertices.add(e.getDestination());
        }

        return vertices;
    }

    public List<Vertex<V>> getNeighbors(Vertex<V> vertex) {
        List<Vertex<V>> neighbors = new ArrayList<>();
        List<Edge<V>> edges = map.get(vertex);

        if (edges != null) {
            for (Edge<V> edge : edges) {
                neighbors.add(edge.getDestination());
            }
        }
        return neighbors;
    }

    public List<Edge<V>> getEdges(Vertex<V> vertex) {
        return map.getOrDefault(vertex, new ArrayList<>());
    }

    public void bfs(Vertex<V> start) {
        Set<Vertex<V>> visited = new HashSet<>();
        Queue<Vertex<V>> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();
            System.out.println(current);

            for (Vertex<V> neighbor : getNeighbors(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }
}
