package src;

import java.util.*;

// Base class for search algorithms
public class Search<Vertex> {
    protected Set<Vertex> visited; // Stores visited vertices
    protected Map<Vertex, Vertex> cameFrom; // Tracks the path
    protected final Vertex start; // Source vertex

    public Search(Vertex start) {
        this.start = start;
        visited = new HashSet<>();
        cameFrom = new HashMap<>();
    }

    // Returns true if there's a path from start to the given vertex
    public boolean hasPathTo(Vertex destination) {
        return visited.contains(destination);
    }

    // Returns the path from start to the given vertex
    public Iterable<Vertex> pathTo(Vertex destination) {
        if (!hasPathTo(destination)) return null;

        LinkedList<Vertex> path = new LinkedList<>();
        for (Vertex current = destination; !current.equals(start); current = cameFrom.get(current)) {
            path.push(current); // Insert at the beginning
        }
        path.push(start); // Add the start vertex

        return path;
    }
}

