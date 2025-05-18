package src;

public class Main {
    public static void main(String[] args) {
        // Create vertices
        Vertex<String> a = new Vertex<>("A");
        Vertex<String> b = new Vertex<>("B");
        Vertex<String> c = new Vertex<>("C");
        Vertex<String> d = new Vertex<>("D");

        // Create graph
        WeightedGraph<String> graph = new WeightedGraph<>();

        // Add vertices to graph
        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        graph.addVertex(d);

        // Add edges with weights
        graph.addEdge(a, b, 1); // A -> B
        graph.addEdge(a, c, 1); // A -> C
        graph.addEdge(b, d, 1); // B -> D
        graph.addEdge(c, d, 1); // C -> D

        // Perform BFS traversal from vertex A
        System.out.print("BFS traversal starting from A: ");
        graph.bfs(a);
    }
}

