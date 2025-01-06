package Day43;

import java.util.*;


class Solution {

    int countPairs(int arr[], int target) {
        // Optimized Approach
        int n = arr.length;
        
        // Initialize frequency mapping of unique elements
        HashMap<Integer, Integer> freq = new HashMap<>();

        // Initialize the count of pairs to 0
        int count = 0;

        // Iterate the array to find the pairs
        for(int i = 0; i < n; i++) {
            
            // Calculate the remaining difference to form a pair
            int diff = target - arr[i];

            // Check if the difference exists in the frequencies
            if(freq.containsKey(diff)) {
                
                // If exists then increment the count by the frequency
                count += freq.get(diff);
            }

            // Increment or Initialize the frequency of current element by 1
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
            
        }
        
        return count;
    }
}
