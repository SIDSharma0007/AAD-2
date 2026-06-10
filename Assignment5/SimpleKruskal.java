import java.util.Arrays;

public class SimpleKruskal {
    static int[] parent = new int[10];

    // Find the boss.
    static int find(int i) {
        if (parent[i] == i) return i;
        return find(parent[i]);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) parent[i] = i; // Setup bosses

        // Edges: {src, dest, weight}
        int[][] edges = {
            {0, 1, 10}, {0, 2, 6}, {0, 3, 5}, 
            {1, 3, 15}, {2, 3, 4}
        };

        // This one line sorts the entire array by the 3rd column (weight) automatically!
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);

        System.out.println("Kruskal's MST Roads to Keep:");
        for (int[] edge : edges) {
            int boss1 = find(edge[0]);
            int boss2 = find(edge[1]);

            // If they have different bosses, it's not a cycle. Keep it!
            if (boss1 != boss2) {
                System.out.println(edge[0] + " - " + edge[1] + " (Cost: " + edge[2] + ")");
                parent[boss1] = boss2; // Union them
            }
        }
    }
}
