package Day67;

class Node {
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

public class optimizedApproach {
    // Optimized Approach
    Node sortedMerge(Node head1, Node head2) {

        Node prev1 = null, curr1 = head1;
        Node prev2 = null, curr2 = head2;
        
        while(curr1 != null || curr2 != null) {
            
            if(curr1 == null) {
                prev1.next = curr2;
                break;
            } else if(curr2 == null) {
                prev2.next = curr1;
                break;
            }
            
            if(curr1.data <= curr2.data) {
                if(prev2 != null) {
                    prev2.next = curr1;
                    prev2 = curr1;
                }
                prev1 = curr1;
                curr1 = curr1.next;
            } else {
                if(prev1 != null) {
                    prev1.next = curr2;
                    prev1 = curr2;
                }
                prev2 = curr2;
                curr2 = curr2.next;
            }
        }
        
        if(head1.data <= head2.data) {
            return head1;
        } else {
            return head2;
        }
    }
}
