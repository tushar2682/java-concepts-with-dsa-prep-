package Graphs;

import java.util.*;

class Solution {

    static ArrayList<String> ans;

    public ArrayList<String> ratInMaze(int[][] maze) {
        ans = new ArrayList<>();
        int n = maze.length;

        if (maze[0][0] == 0) return ans;

        boolean[][] visited = new boolean[n][n];

        solve(0, 0, maze, n, "", visited);

        Collections.sort(ans);
        return ans;
    }

    private static void solve(int i, int j, int[][] maze, int n, String path, boolean[][] visited) {

        // Destination
        if (i == n - 1 && j == n - 1) {
            ans.add(path);
            return;
        }

        visited[i][j] = true;

        // Down
        if (i + 1 < n && maze[i + 1][j] == 1 && !visited[i + 1][j]) {
            solve(i + 1, j, maze, n, path + "D", visited);
        }

        // Left
        if (j - 1 >= 0 && maze[i][j - 1] == 1 && !visited[i][j - 1]) {
            solve(i, j - 1, maze, n, path + "L", visited);
        }

        // Right
        if (j + 1 < n && maze[i][j + 1] == 1 && !visited[i][j + 1]) {
            solve(i, j + 1, maze, n, path + "R", visited);
        }

        // Up
        if (i - 1 >= 0 && maze[i - 1][j] == 1 && !visited[i - 1][j]) {
            solve(i - 1, j, maze, n, path + "U", visited);
        }

        visited[i][j] = false; // Backtrack
    }
}
public class RatinMaze {
    public static void main(String[] args) {
        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}
        };

        Solution obj = new Solution();
        System.out.println(obj.ratInMaze(maze)); // Output: [DDRDRR, DRDDRR]
    }
}679-/+*\=3