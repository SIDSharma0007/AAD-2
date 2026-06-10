import java.util.ArrayList;

public class GraphDFS {
    // A helper method that does the actual recursive searching
    public static void dfsHelper(int node, ArrayList<ArrayList<Integer>> adjList, boolean[] visited) {
        // Mark current node as visited and print it
        visited[node] = true;
        System.out.print(node + " ");

        // Go to all its neighbors
        for (int neighbor : adjList.get(node)) {
            // If the neighbor hasn't been visited, dive deeper into it!
            if (!visited[neighbor]) {
                dfsHelper(neighbor, adjList, visited);
            }
        }
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<V; i++) adjList.add(new ArrayList<>());

        // Build a simple line: 0 -> 1 -> 2 -> 3
        adjList.get(0).add(1);
        adjList.get(1).add(2);
        adjList.get(2).add(3);

        boolean[] visited = new boolean[V];
        System.out.print("DFS Traversal starting from 0: ");
        dfsHelper(0, adjList, visited); 
    }
}
