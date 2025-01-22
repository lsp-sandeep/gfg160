
class Solution:
    # Optimized Approach
    def findEquilibrium(self, arr):
        '''
        This function finds equilibrium point in the array.
        The equilibrium point in an array is an index such that
        the sum of all elements before that index is the same as
        the sum of elements after it
        
        Approach:
        1. Iterate the array to find the total suffix sum
        2. Iterate to increase the prefix sum and decrease the suffix sum
        3. Check at each index if prefix sum is equal to suffix sum
        
        Time Complexity: O(n + n) = O(n)
        Space Complexity: O(1)
        '''
        # Calculate the total sum
        suffix_sum = 0
        for a in arr:
            suffix_sum += a
        
        # Iterate and check if prefix sum equals suffix sum
        prefix_sum = 0
        for i in range(len(arr)):
            suffix_sum -= arr[i]
            
            if prefix_sum == suffix_sum:
                return i
            
            prefix_sum += arr[i]
        
        # Return -1 if no match is found
        return -1