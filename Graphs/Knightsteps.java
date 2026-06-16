import java.util.*;

class Solution {
    // Helper class to store cell coordinates and steps taken to reach it
    static class Cell {
        int x, y, steps;

        Cell(int x, int y, int steps) {
            this.x = x;
            this.y = y;
            this.steps = steps;
        }
    }

    // Function to find out minimum steps a Knight will take to reach the target position.
    public int minStepToReachTarget(int knightPos[], int targetPos[], int n) {
        // Direct match check: if starting position is already the target
        if (knightPos[0] == targetPos[0] && knightPos[1] == targetPos[1]) {
            return 0;
        }

        // The 8 possible directional moves for a Knight
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

        // Visited array to keep track of explored cells (1-indexed matrix)
        boolean[][] visited = new boolean[n + 1][n + 1];

        // Queue for BFS
        Queue<Cell> queue = new LinkedList<>();

        // Initialize BFS with the starting position
        queue.add(new Cell(knightPos[0], knightPos[1], 0));
        visited[knightPos[0]][knightPos[1]] = true;

        while (!queue.isEmpty()) {
            Cell current = queue.poll();

            // If the target position is reached, return the steps
            if (current.x == targetPos[0] && current.y == targetPos[1]) {
                return current.steps;
            }

            // Loop through all 8 valid knight moves
            for (int i = 0; i < 8; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                // Check boundary limits and verify if the cell is unvisited
                if (nextX >= 1 && nextX <= n && nextY >= 1 && nextY <= n && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    queue.add(new Cell(nextX, nextY, current.steps + 1));
                }
            }
        }

        // Return -1 if the target position is completely unreachable
        return -1;
    }
}
public class Knightsteps {
    public static void main(String[] args) {
        Solution obj = new Solution();
        int n = 8; // Size of the chessboard
        int knightPos[] = {1, 1}; // Starting position of the knight
        int targetPos[] = {8, 8}; // Target position to reach

        int result = obj.minStepToReachTarget(knightPos, targetPos, n);
        System.out.println(result); // Output: Minimum steps required for the knight to reach the target
    }
}