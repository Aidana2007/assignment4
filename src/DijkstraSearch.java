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

            Vertex<V> closestVertex = new Vertex<>(closest);

            for (Vertex<V> neighbor : graph.adjacencyList(closestVertex)) {
                V neighborValue = neighbor.getValue();
                double tentative = getDistance(closest) + edgeWeight(closest, neighborValue);

                if (tentative < getDistance(neighborValue)) {
                    minDistances.put(neighborValue, tentative);
                    edgeTo.put(neighborValue, closest);
                    unvisited.add(neighborValue);
                }
            }
        }
    }

    private double getDistance(V v) {
        return minDistances.getOrDefault(v, Double.POSITIVE_INFINITY);
    }

    private double edgeWeight(V from, V to) {
        for (Edge<V> edge : graph.getEdges(new Vertex<>(from))) {
            if (edge.getDestination().getValue().equals(to)) {
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

