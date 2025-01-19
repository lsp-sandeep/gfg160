class Solution:
    # Optimized Approach
    def longestUniqueSubstr(self, s):
        '''
        This function finds the longest unique substring
        
        Approach:
        1. Use a pointer to the start and hashmap of character indexes
        2. Iterate the string  to update latest index of each character
        3. At each iteration if encounter a repeated character
            i. Restart the start pointer to the next index of the character
            ii. Update the count from the new starting point
        4. Else keep incrementing the count and track the maximum count
        
        Time Complexity: O(n)
        Space Complexity: O(26) = O(1)
        '''

        n, start, count, res = len(s), 0, 0, 0
        
        idxs = {}
        # Iterate the string
        for i in range(n):
            # Check if repeated character
            if idxs.get(s[i], -1) >= start:
                # Update the start and count
                start = idxs[s[i]] + 1
                count = i - start + 1
            else:
                # Increment the count
                count += 1
            # Update the current index to the hashmap
            idxs[s[i]] = i
            # Track the maximum count
            res = max(count, res)
        # Return the count at the end of iteration
        return res
