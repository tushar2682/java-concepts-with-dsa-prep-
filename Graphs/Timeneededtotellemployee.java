import java.util.ArrayList;
import java.util.List;

public class Timeneededtotellemployee {
    List<Integer>[] adj;
    int ans = 0;

    public int numOfMinutes(int n, int headID,
                            int[] manager,
                            int[] informTime) {

        adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                adj[manager[i]].add(i);
            }
        }

        dfs(headID, 0, informTime);
        return ans;
    }

    private void dfs(int node, int time, int[] informTime) {
        ans = Math.max(ans, time);

        for (int child : adj[node]) {
            dfs(child, time + informTime[node], informTime);
        }
    }

public static void main(String[] args) {
    Timeneededtotellemployee sol = new Timeneededtotellemployee();

    int n = 6;
    int headID = 2;
    int[] manager = {2, 2, -1, 2, 2, 2};
    int[] informTime = {0, 0, 1, 0, 0, 0};

    System.out.println(sol.numOfMinutes(n, headID, manager, informTime));  // Output: 1
}
}