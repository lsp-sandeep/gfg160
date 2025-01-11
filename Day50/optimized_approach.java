package Day50;
import java.util.*;

class Solution {
    public long subarrayXor(int arr[], int k) {
        // Optimized Approach
        
        // Initialize the frequency map of prefix xors
        HashMap<Integer, Integer> prefix_xor_freq = new HashMap<>();
        
        // Initialize the prefix xor and the resultant count to 0
        int prefix_xor = 0, count = 0;
        
        // Iterate the array
        for(int i = 0; i < arr.length; i++) {
            
            // Calculate the prefix xor with the current element
            prefix_xor ^= arr[i];
            
            // Increment the count with the frequency of
            // the complement of prefix_xor and k in the hashmap
            count += prefix_xor_freq.getOrDefault(prefix_xor^k, 0);

            // Increment the count by 1 if the current prefix xor is k
            count += prefix_xor == k ? 1 : 0;
            
            // Update the frequency hashmap by incrementing the
            // frequency of the current prefix_xor by 1
            prefix_xor_freq.put(
                prefix_xor,
                prefix_xor_freq.getOrDefault(prefix_xor, 0) + 1
            );
            
        }
        
        // Return the resultant count at end of iteration
        return count;
    }
}