import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphBFS {
    public static void bfs(int startNode, ArrayList<ArrayList<Integer>> adjList, int V) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        // Start by putting the first node in the queue
        visited[startNode] = true;
        queue.add(startNode);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll(); // Take the person at the front of the line
            System.out.print(currentNode + " ");

            // Add all unvisited neighbors to the back of the line
            for (int neighbor : adjList.get(currentNode)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<V; i++) adjList.add(new ArrayList<>());

        // 0 is connected to 1 and 2
        adjList.get(0).add(1);
        adjList.get(0).add(2);

        System.out.print("BFS Traversal starting from 0: ");
        bfs(0, adjList, V); // Output will be 0, 1, 2
    }
}
