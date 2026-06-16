import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        int[] state = new int[n];
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (dfs(i, graph, state)) {
                ans.add(i);
            }
        }

        return ans;
    }

    private boolean dfs(int node, int[][] graph, int[] state) {

        if (state[node] != 0) {
            return state[node] == 2;
        }

        state[node] = 1; // visiting

        for (int nei : graph[node]) {
            if (!dfs(nei, graph, state)) {
                return false;
            }
        }

        state[node] = 2; // safe
        return true;
    }
}
public class Eventualsafestate {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        System.out.println(solution.eventualSafeNodes(graph)); // Output: [2, 4, 5, 6]
    }
}