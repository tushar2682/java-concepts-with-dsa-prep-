import java.util.*;

class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        boolean[] visited = new boolean[n];
        int components = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, stones, visited);
                components++;
            }
        }

        return n - components;
    }

    private void dfs(int i, int[][] stones, boolean[] visited) {
        visited[i] = true;

        for (int j = 0; j < stones.length; j++) {
            if (!visited[j] &&
                (stones[i][0] == stones[j][0] ||
                 stones[i][1] == stones[j][1])) {

                dfs(j, stones, visited);
            }
        }
    }
}
public static void main(String[] args) {
    Solution sol = new Solution();

    int[][] stones = {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};
    System.out.println(sol.removeStones(stones));  // Output: 5
}