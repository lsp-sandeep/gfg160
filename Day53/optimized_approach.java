package Day53;
import java.util.*;

class Solution {
    // Optimized Approach
    public List<Integer> sumClosest(int[] arr, int target) {
        // Sort the array
        Arrays.sort(arr);
        
        // Initialize the resultant pair
        ArrayList<Integer> pair = new ArrayList<>();
        
        // Initialize the left and right pointer and the minimum difference
        int left = 0, right = arr.length - 1, min_sum_diff = 0;
        
        // Iterate the array while left pointer is less than right
        while(left < right) {
            
            // Calculate the difference of current sum and the target
            int sum_diff = arr[left] + arr[right] - target;
            // Also calculate the absolute difference
            int abs_sum_diff = sum_diff >= 0 ? sum_diff : -1 * sum_diff;

            // Initialize the resultant pair and minimum sum difference if empty  
            if(pair.isEmpty()) {
                
                pair.add(arr[left]); pair.add(arr[right]);
                min_sum_diff = abs_sum_diff;
            }
            
            // If the current absolute sum difference is 0 then return the pair
            if(abs_sum_diff == 0) {
                
                pair.set(0, arr[left]); pair.set(1, arr[right]);
                return pair;

            } else if(abs_sum_diff < min_sum_diff) {
                // If the current difference is less than the minimum difference
                // Update the pair with the current elements
                pair.set(0, arr[left]); pair.set(1, arr[right]);
                // Update the minimum difference to the current value
                min_sum_diff = abs_sum_diff;
            }

            // Compare the difference of target and sum
            if(sum_diff > 0) {
                // If positive then decrease the right pointer
                right--;
            } else {
                // If negative or same then increase the left pointer
                left++;
            }
        }
        // Return the resultant pair at the end of iteration
        return pair;
    }
}
