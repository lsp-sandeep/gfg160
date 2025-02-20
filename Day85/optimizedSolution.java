
class Node {
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
}

class Solution {
    ArrayList<Integer> inOrder(Node root) {
        /**
         * This function returns the inorder traversal of a given binary tree
         * 
         * Approach: Recursively add the left, root and right in that order
         * 
         * Time Complexity: O(n)
         * Space Compelxity: O(h)
         **/
         
        ArrayList<Integer> out = new ArrayList<>();
        
        if(root == null) return out;
        
        out.addAll(inOrder(root.left));
        out.add(root.data);
        out.addAll(inOrder(root.right));
        
        return out;
    }
}
