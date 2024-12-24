
class Solution:   
    def peakElement(self,arr):
        # Code here
        n = len(arr)
        for i in range(n):
            pre = -float('inf') if i == 0 else arr[i - 1]
            nex = -float('inf') if i == n - 1 else arr[i + 1]
            cur = arr[i]
            
            if cur > pre and cur > nex:
                return i
        
        return -1
