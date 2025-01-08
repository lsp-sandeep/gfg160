package Day47;
import java.util.*;


// Function to return length of longest subsequence of consecutive integers.

class Solution {

    public int longestConsecutive(int[] arr) {
        // Optimized Approach
        
        // Initialize the empty hashset
        HashSet<Integer> arr_set = new HashSet<>();
        
        // Add all the elements to the hashset
        for(int el : arr) {
            arr_set.add(el);
        }
        
        // Initialize the output max count to 0
        int max_count = 0;
        
        // Iterate the array
        for(int el: arr) {
            
            // Check if the current element is the start
            if(arr_set.contains(el - 1)) {
                
                // If the previous element does not exist
                // then continue to the next element
                continue;
            }
            
            // Initialize the current element and the count
            int curr = el, count = 0;
            
            // Iterate while the next element exists in the set
            while(arr_set.contains(curr)) {
                
                // Remove the current element from the set
                // To avoid re computation
                arr_set.remove(curr);

                // increment the curr element and count
                count++; curr++;
            }
            
            
            // Update the output max count if current count is greater
            if(count > max_count) {
                max_count = count;
            }

        }
        
        // Return the output max count at the end of iteration
        return max_count;
    }
}
