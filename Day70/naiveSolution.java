package Day70;
import java.util.*;

class Node {
    int data;
    Node next;
    Node random;

    Node(int x) {
        data = x;
        next = null;
        random = null;
    }
}


class naiveSolution {
    // code here
    public Node cloneLinkedList(Node head) {
        
        if(head == null)
            return null;
        
        HashMap<Node, Node> nodeMap = new HashMap<>();
        Node curr = head;

        while(curr != null) {
            nodeMap.put(curr, new Node(curr.data));
            curr = curr.next;
        }
        
        curr = head;
        
        while(curr != null) {
            Node clone = nodeMap.get(curr);
            clone.next = nodeMap.get(curr.next);
            clone.random = nodeMap.get(curr.random);
            curr = curr.next;
        }
        
        return nodeMap.get(head);
    }
}
