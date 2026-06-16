import java.util.ArrayList;
import java.util.List;

class Solution {
    public int makeConnected(int n, int[][] connections) {
      
        if (connections.length < n - 1) {
            return -1;
        }

        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : connections) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int components = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, graph, visited);
                components++;
            }
        }

        return components - 1;
    }

    private void dfs(int node, List<Integer>[] graph, boolean[] visited) {
        visited[node] = true;

        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }
}
public class Noofoperationforconnectedcomponent {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 4;
        int[][] connections = {{0, 1}, {0, 2}, {1, 2}};
        System.out.println(solution.makeConnected(n, connections)); // Output: 1
    }
}