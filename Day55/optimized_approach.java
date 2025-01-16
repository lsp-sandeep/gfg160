package Day55;

import java.util.*;

class Solution {
    // Optimized Approach
    static int countTriangles(int arr[]) {
        // Sort the array
        Arrays.sort(arr);
        // Initialize the resultant count and start to 0
        int count = 0, start = 0;
        // Iterate the start to ignore the zeros
        while(arr[start] == 0) {
            start++;
        }
        // Iterate the array from the end
        for(int i = arr.length - 1; i > start + 1; i--) {
            // Initialize the left and right pointers
            int left = start, right = i - 1;
            // Iterate while left is less than right
            while(left < right) {
                // Check if sum is greater than the third element
                if(arr[left] + arr[right] > arr[i]) {
                    // If greater then increment count by
                    // the difference of right and left pointer
                    count += right - left;
                    // Decrease the right pointer
                    right--;
                } else {
                    // If the sum is lesser
                    // then increase the left pointer
                    left++;
                }
            }
        }
        // Return the resultant count
        return count;
    }
}
