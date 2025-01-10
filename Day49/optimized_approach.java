package Day49;
import java.util.*;

class Solution {
    public int countSubarrays(int arr[], int k) {
        // Optimized Approach

        // Initialize the hashmap of prefix sum frequencies
        HashMap<Integer, Integer> prefixSumFreq = new HashMap<>();
        
        // Initialize the prefixSum and the resultant count
        int prefixSum = 0, count = 0;
        
        // Iterate the array
        for(int i = 0; i < arr.length; i++) {
            
            // Calculate the prefixSum
            prefixSum += arr[i];
            
            // If prefixSum is equal to k then increment count by 1
            if(prefixSum == k) {
                count += 1;
            }
            
            // If prefixSum - k is in the hashmap
            if(prefixSumFreq.containsKey(prefixSum - k)) {
                
                // Increment the count by the frequency
                count += prefixSumFreq.get(prefixSum - k);
            }

            // Increment the frequency of prefixSum in the hashmap
            prefixSumFreq.put(
                prefixSum,
                prefixSumFreq.getOrDefault(prefixSum, 0) + 1
            );
        }
        
        // Return the resultant count at the end
        return count;
    }
}

