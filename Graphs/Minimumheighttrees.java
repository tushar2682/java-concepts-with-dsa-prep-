import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Minimumheighttrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if (n == 1) {
            return Arrays.asList(0);
        }

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int[] degree = new int[n];

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];

            adj.get(u).add(v);
            adj.get(v).add(u);

            degree[u]++;
            degree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                q.offer(i);
            }
        }

        int remaining = n;

        while (remaining > 2) {
            int size = q.size();
            remaining -= size;

            for (int i = 0; i < size; i++) {
                int leaf = q.poll();

                for (int nei : adj.get(leaf)) {
                    degree[nei]--;

                    if (degree[nei] == 1) {
                        q.offer(nei);
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            ans.add(q.poll());
        }

        return ans;
    }

   public static void main(String[] args) {
        Minimumheighttrees sol = new Minimumheighttrees();

        int n = 6;
        int[][] edges = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};

        System.out.println(sol.findMinHeightTrees(n, edges));  // [3, 4]
    }
}