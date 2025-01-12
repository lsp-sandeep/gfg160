package Day51;

class Solution {
    public int countTriplets(int[] arr, int target) {
        // Optimized Approach
        
        // Initialize the count to 0
        int count = 0;
        // Iterate the array
        for(int i = 0; i < arr.length - 2; i++) {

            // Initialize the left and right pointers
            // for the remaining array on the right
            int left = i + 1, right = arr.length - 1;
            
            // Iterate while the left and right pointers do not cross
            while(left < right) {
                // Calculate the sum
                int sum = arr[i] + arr[left] + arr[right];
                // Compare the sum with the target
                if(sum < target) {
                    // If sum is lesser then increment the left pointer
                    left++;
                } else if(sum > target) {
                    // If sum is greater then decrease the right pointer
                    right--;
                } else {
                    // If sum and target are equal then
                    // count the combinations by accounting for duplicates
                    
                    // Copy the original left and right pointers
                    int left_idx = left, right_idx = right;
                    // Initialize the left and right duplicate counts
                    int left_count = 0, right_count = 0;
                    // Count the duplicates of the left pointer 
                    // that appear before the original right pointer
                    while(arr[left] == arr[left_idx] && left < right_idx) {
                        left++;
                        left_count++;
                    }
                    // Count the duplicates of the right pointer 
                    // that appear after the original left pointer
                    while(arr[right] == arr[right_idx] && left_idx < right) {
                        right--;
                        right_count++;
                    }
                    // Check if left and right elements are same
                    if(arr[left_idx] == arr[right_idx]) {
                        // If same then increment the resultant count
                        // After accounting for the repitition
                        count += left_count * (left_count + 1) / 2;
                    } else {
                        // If not same then increment the resultant count
                        // by the product of left and right counts
                        count += left_count * right_count;
                    }
                }
            }
        }
        // Return the resultant count at the end
        return count;
    }
}

