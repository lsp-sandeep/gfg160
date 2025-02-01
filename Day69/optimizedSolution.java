package Day69;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class optimizedSolution {
    
    static Node reverse(Node head) {
        Node curr = head, prev = null;
        
        while(curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
    static Node trimLeadingZeros(Node head) {
        Node curr = head;
        
        while(curr.data == 0) {
            curr = curr.next;
        }
        
        return curr;
    }
    
    static int countNodes(Node head) {
        Node curr = head; int count = 0;
        
        while(curr != null) {
            curr = curr.next;
            count++;
        }
        
        return count;
    }
    
    // Optimized Approach
    static Node addTwoLists(Node num1, Node num2) {
        
        if(num1 == null) {
            return num2;
        } else if(num2 == null) {
            return num1;
        }
        
        num1 = trimLeadingZeros(num1);
        num2 = trimLeadingZeros(num2);
        
        int n1 = countNodes(num1);
        int n2 = countNodes(num2);
        
        if(n2 > n1)
            return addTwoLists(num2, num1);

        num1 = reverse(num1);
        num2 = reverse(num2);

        Node sum = num1;
        int val = 0, carry = 0, floor = 0;
        
        while(num2 != null || carry != 0) {
            val = num2 == null ? 0 : num2.data;
            num2 = num2 == null ? num2 : num2.next;
            
            floor = (carry + sum.data + val) % 10;
            carry = (carry + sum.data + val) / 10;
            
            sum.data = floor;

            if(sum.next == null && carry != 0) {
                sum.next = new Node(0);
            }

            sum = sum.next;
        }
        
        return reverse(num1);
    }
}
