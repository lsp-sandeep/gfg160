package Day72;
import java.util.*;


 class Node {
    int data;
    Node next;

    Node(int x)
    {
        data = x;
        next = null;
    }
}

class naiveSolution {
    // Naive Solution
    public static Node findFirstNode(Node head) {
        HashSet<Node> nodeSet = new HashSet<>();
        
        Node curr = head;
        
        while(curr != null) {
            if(nodeSet.contains(curr))
                return curr;
            nodeSet.add(curr);
            curr = curr.next;
        }
        
        return null;
    }
}