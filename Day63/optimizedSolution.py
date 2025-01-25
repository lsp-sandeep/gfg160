class Solution:
    # Optimized Approach
    def maxLen(self, arr):
        '''
        This function finds the longest subarray with equal 0s and 1s
        
        Approach:
        1. Iterate the array to calculate the prefix sum by treat 0 as -1
           and keep track of the sums upto the index in a hashmap
        2. If the prefix sum is 0 then update the result to the next index
        3. If the prefix sum exists in the hashmap then update the result
           to the maximum of current result and the difference of
           current index and the current value of the sum in the hashmap
        4. If it doesnt exist already then add it to hashmap
        
        Time Complexity: O(n)
        Space Complexity: O(n)
        '''
        # Initialize an empty hashmap, the prefix and resultant to 0
        prefix_hash = {}
        prefix_sum, res = 0, 0
        
        # Iterate the array to calculate and compare the prefix sum
        for i in range(len(arr)):
            
            prefix_sum += -1 if arr[i] == 0 else 1
            
            if prefix_sum == 0:
                res = i + 1
            elif prefix_sum in prefix_hash:
                # Update the result to the maximum of current value
                # and the length of internal subarray
                res = max(res, i - prefix_hash[prefix_sum])
            
            else:
                prefix_hash[prefix_sum] = i
            
        return res