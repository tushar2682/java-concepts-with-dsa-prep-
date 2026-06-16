import java.util.LinkedList;
import java.util.Queue;

public class Asfarfromland {
    public int maxDistance(int[][] grid) {
        int n = grid.length;

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        if (q.isEmpty() || q.size() == n * n) {
            return -1;
        }

        int[][] dir = {
            {1, 0}, {-1, 0},
            {0, 1}, {0, -1}
        };

        int distance = -1;

        while (!q.isEmpty()) {
            int size = q.size();
            distance++;

            for (int k = 0; k < size; k++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for (int[] d : dir) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr >= 0 && nr < n &&
                        nc >= 0 && nc < n &&
                        grid[nr][nc] == 0) {

                        grid[nr][nc] = 1;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        return distance;
    }

public static void main(String[] args) {
    Asfarfromland sol = new Asfarfromland();

    int[][] grid = {
        {1, 0, 1},
        {0, 0, 0},
        {1, 0, 1}
    };

    System.out.println(sol.maxDistance(grid));  // Output: 2
}
}