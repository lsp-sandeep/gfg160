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
         /*
        * This function identifies and removes loop in a linked list
        * 
        * Approach:
        * 1) Initialize a slow and fast pointer to the head and prev to null
        * 2) Keep moving the slow pointer by 1 and fast pointer by 2
        * 3) Track the pointer pevious to fast in prev
        * 3) When both pointers become equal initiate the slow to head
        * 4) Move the slow and fast pointers by 1 till they are equal
        * 5) Set the pointer next to prev (prev to fast) to null
        *
        * Time Complexity: O(n)
        * Space Complexity: O(1)
        */
        
        // Initialize slow, fast and prev pointers
        Node slow = head, fast = head, prev = null;
        
        // Iterate while fast or next to fast is not null
        while(fast != null && fast.next != null) {

            // Move slow and fast pointers at 1 and 2 speeds
            slow = slow.next;
            prev = fast.next; // Track the pointer previous to fast
            fast = fast.next.next;
            
            // Find the first node of loop
            if(slow == fast) {
                slow = head;
                
                while(slow != fast) {
                    prev = fast;
                    slow = slow.next;
                    fast = fast.next;
                }
                
                // Set the end of the loop to null
                prev.next = null;
                
                return;
            }
        }
        
        return;
    }
}
