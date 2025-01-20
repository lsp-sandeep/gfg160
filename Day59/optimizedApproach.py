class Solution:
    # Optimized Approach
    def maxWater(self, arr):
        '''
        This function calculates the maximum amount of water
        that can be trapped by a series of blocks of different heights
        
        Approach:
        1. Find the length, sum, max element and index of the array
        2. Calculate the free area = total area (len * max) - sum
        3. Iterate from the max index to the two ends of array
        4. Decrease the free area by max - max upto the current index
        
        Time Complexity: O(n + n) = O(n)
        Space Complexity: O(1)
        '''
        # Initialize the length, sum and max of the array
        len_arr, sum_arr, max_el, max_id = len(arr), 0, 0, 0
        # Iterate the array to find the above values
        for i in range(len_arr):
            max_el = max(arr[i], max_el)
            max_id = i if max_el == arr[i] else max_id
            sum_arr += arr[i]

        # Calculate the free area as max area - sum area            
        area = (max_el * len_arr) - sum_arr
        # Initialize the left and right max heights
        left_max, right_max = 0, 0
        # Iterate the left side of the max
        for l in range(max_id):
            # Update the max upto the current index
            left_max = max(arr[l], left_max)
            # Decrease the area by the difference of max heights
            area -= max_el - left_max
        # Do the same for the right side of the max element
        for r in range(len_arr - 1, max_id - 1, -1):
            right_max = max(arr[r], right_max)
            area -= max_el - right_max
        
        # Return the final area
        return area
