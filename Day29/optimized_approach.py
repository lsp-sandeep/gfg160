class Solution:

    def findMin(self, arr):
        #Optimized Approach
        idx = len(arr) - 1
        low, high = 0, len(arr) - 1
        
        while low <= high:
            
            mid = (low + high) // 2
            
            if arr[mid] < arr[high]:
                idx = mid
                high = mid
            else:
                low = mid + 1
        
        return arr[idx]