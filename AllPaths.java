import java.util.ArrayList;

public class AllPaths {
    public static void findPaths(int current, int destination, ArrayList<ArrayList<Integer>> adjList, 
                                 boolean[] visited, ArrayList<Integer> currentPath) {
        
        visited[current] = true;
        currentPath.add(current);

        // If we reached the destination, print the path!
        if (current == destination) {
            System.out.println(currentPath);
        } else {
            // Otherwise, keep searching
            for (int neighbor : adjList.get(current)) {
                if (!visited[neighbor]) {
                    findPaths(neighbor, destination, adjList, visited, currentPath);
                }
            }
        }

        // BACKTRACKING: Unmark the node and remove it from path so other routes can use it
        currentPath.remove(currentPath.size() - 1);
        visited[current] = false; 
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<V; i++) adjList.add(new ArrayList<>());

        adjList.get(0).add(1);
        adjList.get(0).add(2);
        adjList.get(1).add(3);
        adjList.get(2).add(3);

        boolean[] visited = new boolean[V];
        ArrayList<Integer> path = new ArrayList<>();
        
        System.out.println("All paths from 0 to 3:");
        findPaths(0, 3, adjList, visited, path);
    }
}
