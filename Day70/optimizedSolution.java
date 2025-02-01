package Day70;

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

class optimizedSolution {
    // Optimized Approach
    public Node cloneLinkedList(Node head) {
        
        if(head == null)
            return null;
        
        Node curr = head;

        while(curr != null) {
            Node clone = new Node(curr.data);
            clone.next = curr.next;
            curr.next = clone;
            curr = clone.next;
        }
        
        curr = head;
        
        while(curr != null) {
            if(curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        
        curr = head;
        Node cloneHead = head.next;
        Node clone = cloneHead;
        
        while(clone.next != null) {
            curr.next = curr.next.next;
            clone.next = clone.next.next;
            
            curr = curr.next;
            clone = clone.next;
        }
        curr.next = null;
        clone.next = null;

        return cloneHead;
    }
}
