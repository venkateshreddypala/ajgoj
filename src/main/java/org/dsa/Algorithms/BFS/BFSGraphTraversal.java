package org.dsa.Algorithms.BFS;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class BaFSGraphTraversal {

    // BFS using functional programming
    public static void bfs(Map<String, List<String>> graph, String start, Consumer<String> visit) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String node = queue.poll();
            visit.accept(node); // Functional processing

            // Process neighbors functionally
            List<String> neighbors = graph.getOrDefault(node, Collections.emptyList()).stream()
                    .filter(neighbor -> !visited.contains(neighbor))
                    .peek(visited::add)  // Mark as visited
                    .collect(Collectors.toList());

            queue.addAll(neighbors); // Add all unvisited neighbors
        }
    }

    public static void main(String[] args) {
        Map<String, List<String>> graph = Map.of(
                "A", List.of("B", "C"),
                "B", List.of("A", "D", "E"),
                "C", List.of("A", "F"),
                "D", List.of("B"),
                "E", List.of("B", "F"),
                "F", List.of("C", "E")
        );

        System.out.println("BFS Traversal:");
        bfs(graph, "A", node -> System.out.print(node + " ")); // Functional processing
    }
}
