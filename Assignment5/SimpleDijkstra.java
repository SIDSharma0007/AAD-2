import java.util.Arrays;

public class SimpleDijkstra {
    public static void main(String[] args) {
        int V = 5;
        int[][] graph = {
            { 0, 4, 0, 0, 8 },
            { 4, 0, 8, 0, 11 },
            { 0, 8, 0, 7, 0 },
            { 0, 0, 7, 0, 9 },
            { 8, 11, 0, 9, 0 }
        };

        int[] dist = new int[V]; // The Scoreboard
        boolean[] visited = new boolean[V];

        Arrays.fill(dist, 999999);
        dist[0] = 0; // Start at city 0

        for (int count = 0; count < V - 1; count++) {
            // 1. Find the city with the lowest total score
            int min = 999999, u = -1;
            for (int i = 0; i < V; i++) {
                if (!visited[i] && dist[i] <= min) { 
                    min = dist[i]; 
                    u = i; 
                }
            }
            visited[u] = true;

            // 2. The Scoreboard Update
            for (int v = 0; v < V; v++) {
                // If road exists + unvisited + (MyScore + RoadCost < Neighbor's Current Score)
                if (!visited[v] && graph[u][v] != 0 && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v]; // Overwrite with new cheaper score
                }
            }
        }

        System.out.println("Fastest routes from City 0:");
        for (int i = 0; i < V; i++) System.out.println("To City " + i + " -> Cost: " + dist[i]);
    }
}
