class Solution:
    # Optimized Approach
    def longestSubarray(self, arr, k):  
        '''
        This function finds the longest subarray where the sum of its
        elements equal to the given value k.
        
        Approach:
        1. Create a frequency hashmap of prefix sums from left to right
        2. Iterate the array from the right to check if the difference of
           suffix sum and the target exists in the hashmap, if so then
           update the longest of the difference in index
        
        Time Complexity: O(n) + O(n) = O(n)
        Space Complexity: O(n)
        '''
        n, prefix_sum, freq = len(arr), 0, {}
        # Create frequency hashmap of prefix sums
        for i in range(n):
            
            freq[prefix_sum] = min(freq.get(prefix_sum, n), i)
            
            prefix_sum += arr[i]

        suffix_sum, length = prefix_sum, 0

        # Check the matching index for each suffix sum and
        # Keep track of the longest length
        for i in range(n - 1, -1, -1):
            
            diff = suffix_sum - k

            if diff in freq:
                
                length = max(length, i - freq.get(diff) + 1)
                
            suffix_sum -= arr[i]
            
        # Return the longest length after iteration
        return length