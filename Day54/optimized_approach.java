package Day54;

class optimized_apprach {
    // Optimized Approach
    int countPairs(int arr[], int target) {
        // Initialize left and right pointers to begin and end of array
        int left = 0, right = arr.length - 1;
        // Initialize the resultant count to 0
        int count = 0;
        
        // Iterate the array while left is less than right pointer
        while(left < right) {
            // Calculate the sum of the left and right pointer
            int sum = arr[left] + arr[right];
            
            // Compare the sum with the target
            if(sum < target) {
                // If sum less than target increment the left pointer
                left++;
            } else if(sum > target) {
                // If sum greater than target decrease the right pointer
                right--;
            } else {
                // If the sum matches with target then
                // Count the repeating element from left and right
                
                // Initialize the original left and right pointers
                int left_idx = left, right_idx = right;
                // Initialize the left and right repetition to 0 
                int left_count = 0, right_count = 0;
                
                // Count the left repetition upto the original right pointer
                while(arr[left_idx] == arr[left] && left < right_idx) {
                    left++;
                    left_count++;
                }

                // Count the right repetition upto the original left pointer
                while(arr[right_idx] == arr[right] && right > left_idx) {
                    right--;
                    right_count++;
                }
                
                // Increment the count by total combinations
                if(arr[left_idx] == arr[right_idx]) {
                    // If original left and right are same then
                    // account for duplication
                    count += left_count * (right_count + 1) / 2;
                } else {
                    // If not then multiply the left and right counts
                    count += left_count * right_count;
                }
            }
        }
        // Return the resultant count at the end of iteration
        return count;
    }
}

