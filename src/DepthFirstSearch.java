package src;

import java.util.*;

// Implements Depth-First Search (DFS) on an unweighted graph
public class DepthFirstSearch<V> extends Search<V> {

    // Constructor runs DFS starting from the source vertex
    public DepthFirstSearch(UnweightedGraph<Vertex<V>> graph, Vertex<V> start) {
        super((V) start); // initialize Search class

        dfs(graph, start);
    }

    // Recursive DFS function
    private void dfs(UnweightedGraph<Vertex<V>> graph, Vertex<V> current) {
        marked.add((V) current); // mark as visited

        for (Vertex<V> neighbor : graph.adjacencyList(current)) {
            if (!marked.contains(neighbor)) {
                edgeTo.put((V) neighbor, (V) current); // remember the path
                dfs(graph, neighbor); // recursive call
            }
        }
    }
}
