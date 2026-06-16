import java.util.*;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.List;
class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
       List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[V];
        int[] parent = new int[V];
        Arrays.fill(parent, -1); // Initialize all parents to -1

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (bfsCheck(i, adj, visited, parent)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bfsCheck(int src, List<List<Integer>> adj, boolean[] visited, int[] parent) {
        Queue<Integer> q = new LinkedList<>();
        
        visited[src] = true;
        q.add(src);

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    parent[neighbor] = node;
                    q.add(neighbor);
                } 
                else if (parent[node] != neighbor) {
                    return true; 
                }
            }
        }
        return false;
    }
}
public class CycleDetection {
    public static void main(String[] args) {
        Solution obj = new Solution();
        int V = 5;
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}, {3, 4}};
        boolean result = obj.isCycle(V, edges);
        System.out.println(result); // Output: true
    }
}