import java.util.ArrayList;

public class DFS {
     public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];
        ArrayList<Integer> result = new ArrayList<>();

        dfsHelper(0, adj, visited, result);
        return result;
    }

    private void dfsHelper(int node,
                           ArrayList<ArrayList<Integer>> adj,
                           boolean[] visited,
                           ArrayList<Integer> result) {

        visited[node] = true;
        result.add(node);

        for (int neigh : adj.get(node)) {
            if (!visited[neigh]) {
                dfsHelper(neigh, adj, visited, result);  // ✅ recursion
            }
        }
    }
public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
        adj.add(new ArrayList<>());
    }
 adj.get(0).add(1);
    adj.get(0).add(2);
    adj.get(1).add(0);
    adj.get(1).add(3);
    adj.get(2).add(0);
    adj.get(2).add(4);
    adj.get(3).add(1);
    adj.get(4).add(2);

    DFS obj = new DFS();
    System.out.println(obj.dfs(adj));  // [0, 1, 3, 2, 4]
}
}