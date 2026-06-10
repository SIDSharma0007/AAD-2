import java.util.ArrayList;
import java.util.LinkedList;

public class GraphRepresentation {
    public static void main(String[] args) {
        int vertices = 4; // Let's make a graph with 4 nodes (0, 1, 2, 3)
        
        // --- 1. ADJACENCY MATRIX ---
        int[][] matrix = new int[vertices][vertices];
        
        // Add an undirected edge between 0 and 1
        matrix[0][1] = 1;
        matrix[1][0] = 1; // Since it's undirected, it goes both ways!
        
        System.out.println("Adjacency Matrix:");
        for(int i = 0; i < vertices; i++) {
            for(int j = 0; j < vertices; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // --- 2. ADJACENCY LIST ---
        // An array of LinkedLists
        ArrayList<LinkedList<Integer>> list = new ArrayList<>();
        for(int i = 0; i < vertices; i++) {
            list.add(new LinkedList<Integer>());
        }
        
        // Add an undirected edge between 0 and 1
        list.get(0).add(1);
        list.get(1).add(0);
        
        System.out.println("\nAdjacency List:");
        for(int i = 0; i < vertices; i++) {
            System.out.println("Node " + i + " is connected to: " + list.get(i));
        }
    }
}
