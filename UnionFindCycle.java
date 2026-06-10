public class UnionFindCycle {
    int[] parent;

    // Initially, every node is its own boss
    public UnionFindCycle(int vertices) {
        parent = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            parent[i] = i; 
        }
    }

    // Find the absolute top boss of a node
    public int find(int i) {
        if (parent[i] == i)
            return i;
        return find(parent[i]);
    }

    // Make two nodes friends (put them under the same boss)
    public void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        parent[rootI] = rootJ; // rootJ is now the boss of rootI
    }

    public static void main(String[] args) {
        UnionFindCycle graph = new UnionFindCycle(3);
        
        // Edge 0-1
        int x = graph.find(0);
        int y = graph.find(1);
        graph.union(x, y);

        // Edge 1-2
        x = graph.find(1);
        y = graph.find(2);
        graph.union(x, y);

        // Edge 0-2 (This creates a cycle!)
        x = graph.find(0);
        y = graph.find(2);
        
        // If they already have the same boss, adding this edge makes a loop!
        if (x == y) {
            System.out.println("Cycle Detected!");
        } else {
            graph.union(x, y);
        }
    }
}
