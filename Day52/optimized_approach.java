package Day52;

import java.util.*;

class Solution {
    // Optimized Approch
    int countPairs(int arr[], int target) {
        // Sort the array
        Arrays.sort(arr);
        
        // Initialize the left and right pointers
        // to the start and end of the array
        int left = 0, right = arr.length - 1;
        
        // Initialize the resultant count to 0
        int count = 0;
        
        // Iterate while the left is less than right
        while(left < right) {
            
            // Calculate the sum of the current elements
            int sum = arr[left] + arr[right];
            
            // Compare the sum with the target
            if(sum < target) {
                
                // If sum is lesser then increment the
                // count by the difference of pointers
                count += right - left;
                
                // And increase the left pointer by 1
                left++;
            } else {
                // If sum is greater or equal to target
                // decrease the right pointer by 1
                right--;
            }
        }
        
        // Return the resultant count
        return count;
    }
}
