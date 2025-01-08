package Day46;
import java.util.*;

class Solution {
    public static int findUnion(int a[], int b[]) {
        // Optimized Approach
        
        // Initialized the hashset
        HashSet<Integer> union_set = new HashSet<>();
        
        // Iterate the first array
        // and add elements to the union set
        for(int el : a) {
            union_set.add(el);
        }
        
        // Iterate the second array
        // and add elements to the union set
        for(int el : b) {
            union_set.add(el);
        }
        
        // Return the size of the union set
        return union_set.size();
    }
}


