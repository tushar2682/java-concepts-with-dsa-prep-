import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    int[][] dir = {
        {-1, 0},
        {1, 0},
        {0, 1},
        {0, -1}
    };

    int rows, cols;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        rows = heights.length;
        cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // Pacific: top row and left column
        for (int c = 0; c < cols; c++) {
            dfs(heights, pacific, 0, c);
        }

        for (int r = 0; r < rows; r++) {
            dfs(heights, pacific, r, 0);
        }

        // Atlantic: bottom row and right column
        for (int c = 0; c < cols; c++) {
            dfs(heights, atlantic, rows - 1, c);
        }

        for (int r = 0; r < rows; r++) {
            dfs(heights, atlantic, r, cols - 1);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    ans.add(Arrays.asList(r, c));
                }
            }
        }

        return ans;
    }

    private void dfs(int[][] heights,
                     boolean[][] visited,
                     int r,
                     int c) {

        visited[r][c] = true;

        for (int[] d : dir) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr < 0 || nr >= rows ||
                nc < 0 || nc >= cols ||
                visited[nr][nc] ||
                heights[nr][nc] < heights[r][c]) {
                continue;
            }

            dfs(heights, visited, nr, nc);
        }
    }
}
public class PacificAtlantic {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] heights = {
            {1, 2, 2, 3, 5},
            {3, 2, 3, 4, 4},
            {2, 4, 5, 3, 1},
            {6, 7, 1, 4, 5},
            {5, 1, 1, 2, 4}
        };
        List<List<Integer>> result = solution.pacificAtlantic(heights);
        System.out.println(result);
    }
}
