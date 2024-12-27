class Solution:
        
    def kthMissing(self, arr, k):
        # Optimized Approach
        n = len(arr)
        
        if k < arr[0]:
            return k
        if k > arr[-1] - n:
            return (arr[-1]) + (k - (arr[-1] - n))

        low, high = 0, n - 1

        while low <= high:
            mid = low + (high - low) // 2
            
            mid_index = arr[mid] - (mid + 1)
            next_mid_index = arr[mid + 1] - (mid + 2)
            
            if mid_index < k <= next_mid_index:
                
                break

            if k <= mid_index:

                high = mid - 1

            else:

                low = mid + 1

        return arr[mid] + (k - mid_index)
