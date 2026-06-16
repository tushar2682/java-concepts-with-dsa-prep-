import java.util.*;

// 1. Define the Node class properly so the compiler recognizes it
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {

    public Node cloneGraph(Node node) {  
        if (node == null) return null;
        // Removed the node.neighbors.isEmpty() check as the BFS naturally handles it.

        HashMap<Node, Node> cp = new HashMap<>();
        Queue<Node> qu = new LinkedList<>();

        cp.put(node, new Node(node.val));
        qu.offer(node);

        while(!qu.isEmpty()) {
            Node curr = qu.poll();
            for(Node nei: curr.neighbors) {
                if(!cp.containsKey(nei)) {
                    cp.put(nei, new Node(nei.val));
                    qu.add(nei);
                }
                // Connect the clone of curr to the clone of nei
                cp.get(curr).neighbors.add(cp.get(nei));
            }
        }
        return cp.get(node);
    }

    // 2. The main method must live INSIDE a class block
    public static void main(String[] args) {
        // Build Example Graph: 1-[2,4], 2-[1,3], 3-[2,4], 4-[1,3]
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        CloneGraph obj = new CloneGraph();
        Node clonedNode = obj.cloneGraph(node1);

        // Verification Output
        System.out.println("Original Starting Node Address: " + node1);
        System.out.println("Cloned Starting Node Address:   " + clonedNode);
        System.out.println("Cloned Node Value: " + clonedNode.val);
        System.out.println("Cloned Neighbors count: " + clonedNode.neighbors.size());
    }
}