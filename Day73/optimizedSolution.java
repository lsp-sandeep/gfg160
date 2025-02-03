package Day73;

class Node
{
    int data;
    Node next;
}

// Function to remove a loop in the linked list.
class optimizedSolution {
    // Optimized Approach
    public static void removeLoop(Node head) {
        Node slow = head, fast = head, prev = null;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            prev = fast.next;
            fast = fast.next.next;
            
            if(slow == fast) {
                slow = head;
                
                while(slow != fast) {
                    prev = fast;
                    slow = slow.next;
                    fast = fast.next;
                }
                
                prev.next = null;
                
                return;
            }
        }
        
        return;
    }
}
