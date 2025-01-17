package Day56;
import java.util.*;


public class optimized_appraoch {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // Optimized Approach
        
        // Initialize the left and right pointers to 0
        // Initialize the sum to the first element
        int left = 0, right = 0, sum = arr[0];
        
        // Initialize the result to an empty list
        ArrayList<Integer> res = new ArrayList<>();
        
        // Iterate the array while left is less than right
        // and left and right pointers are less than the size
        while(left <= right && left < arr.length && right < arr.length) {

            // Compare the current sum with target
            if(sum < target) {
                // If sum is lesser then increase the right pointer
                // and add the next element to the sum
                right++;
                if(right < arr.length) sum += arr[right];

            } else if(sum > target) {
                // If sum is equal then remove the left pointer
                sum -= arr[left];

                if(left == right) {
                    // If left and right point to same index
                    // then increment the right pointer and sum
                    right++;
                    if(right < arr.length) sum += arr[right];
                }

                // and increase the left pointer
                left++;

            } else {
                // If sum matches the target then return the pointers
                res.add(left + 1);
                res.add(right + 1);

                return res;
            }
        }
        
        // If a match is not found then return -1
        res.add(-1);
        return res;
    }
}
    