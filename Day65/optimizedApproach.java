
class Node {
    int data;
    Node next;
    Node(int value) {
        this.value = value;
    }
}

class Solution {
    // Optimized Approach
    Node reverseList(Node head) {
        /*
        * This function returns the reversed linked list
        * 
        * Approach:
        * 1. Start with the head and iterate while it is not null
        * 2. At each iteration swap the next pointer to the previous node
        *
        * Time Complexity: O(n)
        * Space Complexity: O(1)
        */
    
        // Initialize the curr to head, prev and next to null
        Node curr = head, prev = null, next;
        
        // Iterate while curr is not null
        while(curr != null) {
            
            // Swap the next pointer to the previous node
            next = curr.next;
            curr.next = prev;

            // Move to next node            
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}
