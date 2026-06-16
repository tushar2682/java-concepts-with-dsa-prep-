import java.util.*;

class CouseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        // Build graph
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prerequisite = pre[1];

            adj.get(prerequisite).add(course);
            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();

        // Add all nodes with indegree 0
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int idx = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            result[idx++] = node;

            for (int neigh : adj.get(node)) {
                indegree[neigh]--;

                if (indegree[neigh] == 0) {
                    q.offer(neigh);
                }
            }
        }

        // Cycle exists
        if (idx != numCourses) {
            return new int[0];
        }

        return result;
    }

    public static void main(String[] args) {
        CouseSchedule2 sol = new CouseSchedule2();

        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};

        int[] order = sol.findOrder(numCourses, prerequisites);

        System.out.println(Arrays.toString(order));
    }
}