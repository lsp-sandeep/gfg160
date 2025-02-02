package Day72;

class Node
{
    int data;
    Node next;

    Node(int x)
    {
        data = x;
        next = null;
    }
}

class optimizedSolution {
    // Optimized Approach
    public static Node findFirstNode(Node head) {

        Node slow = head, fast = head;
        
        while(fast != null && fast.next != null) {
            
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast) {
                slow = head;
                
                while(slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                
                return slow;
            }
        }
        
        return null;
    }
}
