package Day71;
import java.util.*;

class Node {
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

class Solution {
    // Function to check if the linked list has a loop.
    // Add code here
    public static boolean detectLoop(Node head) {
        HashSet<Node> nodeSet = new HashSet<>();
        
        Node curr = head;
        
        while(curr != null) {
            if(nodeSet.contains(curr))
                return true;
            nodeSet.add(curr);
            curr = curr.next;
        }
        
        return false;
    }
}
