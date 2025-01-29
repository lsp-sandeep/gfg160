package Day68;

class Node {
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

public class optimizedApproach {
    // Optimized Approach
    public static Node reverseKGroup(Node head, int k) {
        if(head == null) {
            return head;
        }
        
        Node curr = head;
        Node newHead = null;
        Node tail = null;
        
        while(curr != null) {
            Node currHead = curr;
            Node prev = null;
            Node next = null;
            int count = 0;
            
            while(curr != null && count < k) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }
            
            if(newHead==null) {
                newHead = prev;
            }
            
            if(tail!=null) {
                tail.next = prev;
            }

            tail = currHead;
        }
        return newHead;
    }
}
