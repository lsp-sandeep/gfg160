class Solution:
    # Optimized Approach
    def maxWater(self, arr):
        '''
        This function calculates the maximum amount of water
        that can be trapped between any two lines of a given array
        
        Approach:
        1. Initialize two pointers at both ends and the area to 0
        2. Iterate the array to keep track of the maximum area
        3. At each iteration increment the pointer with lesser value
        
        Time Complexity: O(n)
        Space Complexity: O(1)
        '''
        # Initialize two pointers at both ends and the area to 0
        area, left, right = 0, 0, len(arr) - 1
        
        # Iterate the array while left index is less than the right
        while left < right:
            # Keep track of the maximum area
            area = max(min(arr[left], arr[right]) * (right - left), area)
            
            # Increment the pointer with lesser value
            if arr[left] < arr[right]:
                left += 1
            else:
                right -= 1

        # Return the maximum area at end of iteration
        return area