import java.util.ArrayList;

public class StronglyConnected {
    // Number of vertices
    static int V;

    // Check if the directed graph is strongly connected
    public static boolean isStronglyConnected(ArrayList<ArrayList<Integer>> adj) {
        // Step 1: DFS from vertex 0 on the original graph
        boolean[] visited = new boolean[V];
        dfs(0, adj, visited);

        // If any vertex is not visited, the graph is not strongly connected
        for (boolean v : visited) {
            if (!v) return false;
        }

        // Step 2: Build the transpose graph (reverse all edges)
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
        for (int i = 0; i < V; i++) transpose.add(new ArrayList<>());
        for (int u = 0; u < V; u++) {
            for (int v : adj.get(u)) {
                transpose.get(v).add(u);   // reverse edge
            }
        }

        // Step 3: DFS from vertex 0 on the transpose graph
        visited = new boolean[V];           // reset visited array
        dfs(0, transpose, visited);

        // Again, check if all vertices are visited
        for (boolean v : visited) {
            if (!v) return false;
        }

        return true;
    }

    // Standard DFS recursion
    static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited);
            }
        }
    }

    // Driver code
    public static void main(String[] args) {
        // Example: a strongly connected graph (0→1→2→0)
        V = 3;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(0).add(1);   // 0 → 1
        adj.get(1).add(2);   // 1 → 2
        adj.get(2).add(0);   // 2 → 0

        System.out.println("Graph is strongly connected? " + isStronglyConnected(adj));
    }
}
