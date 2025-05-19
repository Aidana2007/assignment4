package src;

import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    private final Set<V> unvisited;
    private final Map<V, Double> minDistances;
    private final WeightedGraph<V> graph;

    public DijkstraSearch(WeightedGraph<V> graph, V start) {
        super(start);
        this.graph = graph;
        this.unvisited = new HashSet<>();
        this.minDistances = new HashMap<>();

        computeShortestPaths();
    }

    private void computeShortestPaths() {
        minDistances.put(source, 0.0);
        unvisited.add(source);

        while (!unvisited.isEmpty()) {
            V closest = selectMin(unvisited);
            unvisited.remove(closest);
            marked.add(closest);

            for (Vertex<V> neighbor : graph.adjacencyList((Vertex<V>) closest)) {
                double tentative = getDistance(closest) + edgeWeight(closest, (V) neighbor);

                if (tentative < getDistance((V) neighbor)) {
                    minDistances.put((V) neighbor, tentative);
                    edgeTo.put((V) neighbor, closest);
                    unvisited.add((V) neighbor);
                }
            }
        }
    }

    private double getDistance(V v) {
        return minDistances.getOrDefault(v, Double.POSITIVE_INFINITY);
    }

    private double edgeWeight(V from, V to) {
        for (Edge<V> edge : graph.getEdges((Vertex<V>) from)) {
            if (edge.getDestination().equals(to)) {
                return edge.getWeight();
            }
        }
        throw new IllegalArgumentException("No edge from " + from + " to " + to);
    }

    private V selectMin(Set<V> vertices) {
        V best = null;
        for (V v : vertices) {
            if (best == null || getDistance(v) < getDistance(best)) {
                best = v;
            }
        }
        return best;
    }
}
