import java.util.Arrays;
import java.util.List;
import java.util.*;import java.util.*;
class DSU {
    private int[] parent;
    private int[] rank;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    // Find with Path Compression
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // Union by Rank
    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return false; // already connected
        }

        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }

        return true;
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}
public class Dsu {
    public static void main(String[] args) {
        DSU dsu = new DSU(5);

        dsu.union(0, 1);
        dsu.union(1, 2);
        dsu.union(3, 4);

        System.out.println(dsu.isConnected(0, 2)); // true
        System.out.println(dsu.isConnected(0, 3)); // false
        System.out.println(dsu.isConnected(3, 4)); // true
    }
}