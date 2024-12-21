class Solution:

    def findMin(self, arr):
        # Naive Approach
        min_el = arr[0]

        for i in range(1, len(arr)):
            min_el = min(min_el, arr[i])
        
        return min_el
