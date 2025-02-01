package Day71;

class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

class Solution {
    // Function to check if the linked list has a loop.
    // Optimized Approach
    public static boolean detectLoop(Node head) {
        Node slow = head, fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast)
                return true;
        }
        
        return false;
    }
}