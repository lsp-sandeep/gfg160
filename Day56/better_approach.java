package Day56;
import java.util.*;

public class better_approach {
    // Better Approach
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // Initialize the suffix sums to an empty hashmap
        HashMap<Integer, Integer> suffix_sums = new HashMap<>();
        
        // Initialize the suffix sum to 0
        int suffix_sum = 0;

        // Iterate the array
        for(int i = arr.length -1; i >= 0; i--) {

        // Update the recent index of suffix sum
            suffix_sums.put(suffix_sum, i + 1);
            suffix_sum += arr[i];
        }
        
        // Initialize the resultant list
        ArrayList<Integer> res = new ArrayList<>();

        // Iterate the array to check for matching suffix sum
        for(int i = 0; i < arr.length; i++) {
            
            // If the suffix_sum - target exists
            if(suffix_sums.containsKey(suffix_sum - target)) {
                // Then return the current and matching index
                res.add(i + 1);
                res.add(suffix_sums.get(suffix_sum - target));
                return res;
            }
            
            // Else decrease the suffix sum by current element
            suffix_sum -= arr[i];
        }
        
        // If no match is found then return -1
        res.add(-1);
        return res;
    }
}