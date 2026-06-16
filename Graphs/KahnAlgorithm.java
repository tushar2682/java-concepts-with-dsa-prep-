import java.util.*;

public class KahnAlgorithm {

    public static List<Integer> topologicalSort(int V, List<List<Integer>> adj) {

        int[] indegree = new int[V];

        // Calculate indegree
        for (int i = 0; i < V; i++) {
            for (int neigh : adj.get(i)) {
                indegree[neigh]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        // Add nodes with indegree 0
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> topo = new ArrayList<>();

        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);

            for (int neigh : adj.get(node)) {
                indegree[neigh]--;

                if (indegree[neigh] == 0) {
                    q.offer(neigh);
                }
            }
        }

        return topo;
    }

    public static void main(String[] args) {
        int V = 6;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        List<Integer> result = topologicalSort(V, adj);

        System.out.println(result);
    }
} 
