package src;

// Implements Depth-First Search (DFS) on an unweighted graph
public class DepthFirstSearch<V> extends Search<V> {

    // Constructor runs DFS starting from the source vertex
    public DepthFirstSearch(UnweightedGraph<V> graph, V start) {
        super(start); // initialize Search class

        dfs(graph, start);
    }

    // Recursive DFS function
    private void dfs(UnweightedGraph<V> graph, V current) {
        marked.add(current); // mark as visited

        for (V neighbor : graph.adjacencyList(current)) {
            if (!marked.contains(neighbor)) {
                edgeTo.put(neighbor, current); // remember the path
                dfs(graph, neighbor); // recursive call
            }
        }
    }
}
