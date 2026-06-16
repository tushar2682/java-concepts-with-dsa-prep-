import java.util.*;

class Solution {
    // 4-directional offsets: Up, Down, Left, Right
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        boolean foundFirstIsland = false;

        // Step 1: Find the first island and gather all its cells using DFS
        for (int i = 0; i < n; i++) {
            if (foundFirstIsland) break;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, n, queue);
                    foundFirstIsland = true; // Found the entire first island, break out
                    break;
                }
            }
        }

        // Step 2: Multi-source BFS to expand outwards and find the shortest path to Island 2
        int bridges = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            // Process all cells in the current expansion layer
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                
                for (int d = 0; d < 4; d++) {
                    int nextX = curr[0] + dx[d];
                    int nextY = curr[1] + dy[d];

                    // Check if the adjacent cell is within the grid boundaries
                    if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n) {
                        if (grid[nextX][nextY] == 1) {
                            // Reached the second island! Return current bridge count.
                            return bridges;
                        } else if (grid[nextX][nextY] == 0) {
                            // It's water: mark it visited (set to 2) and add to queue
                            grid[nextX][nextY] = 2;
                            queue.add(new int[]{nextX, nextY});
                        }
                    }
                }
            }
            // Increment the bridge count as we expand to the next layer of water
            bridges++;
        }

        return -1;
    }

    // Helper DFS function to mark the first island and record its coordinates
    private void dfs(int[][] grid, int x, int y, int n, Queue<int[]> queue) {
        // Base case: check bounds and make sure it's unvisited land
        if (x < 0 || x >= n || y < 0 || y >= n || grid[x][y] != 1) {
            return;
        }

        // Mark as visited by transforming 1 -> 2
        grid[x][y] = 2;
        queue.add(new int[]{x, y});

        // Recurse in all 4 directions
        for (int i = 0; i < 4; i++) {
            dfs(grid, x + dx[i], y + dy[i], n, queue);
        }
    }
}
public class ShortestBridge {
    public static void main(String[] args) {
        Solution obj = new Solution();
        int[][] grid = {
            {0, 1, 0},
            {0, 0, 0},
            {0, 0, 1}
        };
        int result = obj.shortestBridge(grid);
        System.out.println(result); // Output: 2
    }
}