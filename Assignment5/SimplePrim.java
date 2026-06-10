import java.util.Arrays;

public class SimplePrim {
    public static void main(String[] args) {
        int V = 5;
        int[][] graph = {
            { 0, 2, 0, 6, 0 },
            { 2, 0, 3, 8, 5 },
            { 0, 3, 0, 0, 7 },
            { 6, 8, 0, 0, 9 },
            { 0, 5, 7, 9, 0 }
        };

        int[] key = new int[V];
        int[] parent = new int[V];
        boolean[] visited = new boolean[V];

        Arrays.fill(key, 999999); // Use a big number for infinity
        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < V - 1; count++) {
            // 1. Find the cheapest unvisited city
            int min = 999999, u = -1;
            for (int i = 0; i < V; i++) {
                if (!visited[i] && key[i] < min) { 
                    min = key[i]; 
                    u = i; 
                }
            }
            visited[u] = true;

            // 2. Update the costs of its neighbors
            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !visited[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        System.out.println("Prim's MST Connections:");
        for (int i = 1; i < V; i++) System.out.println(parent[i] + " connects to " + i);
    }
}
