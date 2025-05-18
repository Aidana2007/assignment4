package src;

import java.util.*;

// Performs BFS on an unweighted graph from a starting vertex
public class BreadthFirstSearch<Vertex> extends Search<Vertex> {

    // Constructor to perform BFS starting from the given source
    public BreadthFirstSearch(UnweightedGraph<Vertex> graph, Vertex source) {
        super(source); // call Search constructor
        bfs(graph, source); // run BFS
    }

    // Internal method to perform BFS
    private void bfs(UnweightedGraph<Vertex> graph, Vertex source) {
        Queue<Vertex> queue = new LinkedList<>(); // queue for BFS
        marked.add(source); // mark source as visited
        queue.offer(source); // enqueue source

        while (!queue.isEmpty()) {
            Vertex current = queue.poll(); // dequeue current

            for (Vertex neighbor : graph.adjacencyList(current)) {
                if (!marked.contains(neighbor)) {
                    marked.add(neighbor); // mark visited
                    edgeTo.put(neighbor, current); // store path
                    queue.offer(neighbor); // enqueue neighbor
                }
            }
        }
    }
}
