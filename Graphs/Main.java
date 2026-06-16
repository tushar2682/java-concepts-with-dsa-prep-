import java.util.*;

class Solution {
    public boolean Keyroom(List<List<Integer>> rooms) {
        // Track visited rooms
        Set<Integer> visited = new HashSet<>();
        // Queue for BFS traversal
        Queue<Integer> q = new LinkedList<>();
        
        // Start by visiting room 0
        q.offer(0);
        visited.add(0);
        
        // Standard BFS loop
        while (!q.isEmpty()) {
            int curr = q.poll();
            
            // Get the list of keys available in the current room
            for (int key : rooms.get(curr)) {
                // If we haven't visited the room corresponding to this key
                if (!visited.contains(key)) {
                    visited.add(key);
                    q.offer(key);
                }
            }
        }
        
        // If the number of visited rooms equals total rooms, we visited them all
        return visited.size() == rooms.size();
    }
}

// Wrap the main method into a proper driver class
public class Main {
    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1));  // Room 0 has key to room 1
        rooms.add(Arrays.asList(2));  // Room 1 has key to room 2
        rooms.add(Arrays.asList(3));  // Room 2 has key to room 3
        rooms.add(new ArrayList<>()); // Room 3 has no keys

        Solution obj = new Solution();
        boolean result = obj.Keyroom(rooms);
        System.out.println(result);  // Output: true
    }
}