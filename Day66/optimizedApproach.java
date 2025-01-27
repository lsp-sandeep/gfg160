package Day66;

class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}

public class optimizedApproach {
    public Node rotate(Node head, int k) {
        /*
        * This function rotates the linked list k times
        * 
        * Approach:
        * 1. Find the length of the linked list
        * 2. Make it circular by pointing tail to the head
        * 3. Take modulo of k with length and iterate to kth node
        * 4. Point the head to the (k+1)th node
        * 5. Break the loop by pointing the (k+1)th node to null
        *
        * Time Complexity: O(n + k) = O(n)
        * Space Complexity: O(1)
        */
        // Return the head if either k is 0 or head is null
        if(head == null || k == 0)
            return head;

        // Find the length of the linked list        
        int n = 1; Node curr = head;
        while(curr.next != null) {
            curr = curr.next;
            n += 1;
        }
        // Take modulo with the length
        k %= n;
        // Return the head if k is 0
        if(k == 0) return head;
        
        // Point the tail to the head
        curr.next = head;
        
        // Iterate to the kth node
        curr = head;
        for(int i = 1; i < k; i++)
            curr = curr.next;

        // Point the head to the (k+1)th node
        head = curr.next;
        // Break the loop by pointing the (k+1)th node to null
        curr.next = null;

        return head;
    }
}
