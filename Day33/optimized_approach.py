#User function Template for python3


class Solution:
    # Optimized Approach
    def check(self, stalls, diff, k):
        
        count = 1
        prev = stalls[0]
        for i in range(1, len(stalls)):
            if stalls[i] - prev >= diff:
                count += 1
                prev = stalls[i]
            
            if count >= k:
                return True
        
        return False
        
    def aggressiveCows(self, stalls, k):
        
        stalls.sort()

        low, high = 1, stalls[-1] - stalls[0]
        
        res = 0
        while low <= high:
            mid = low + (high - low) // 2

            if self.check(stalls, mid, k):
                res = mid
                low = mid + 1
            else:
                high = mid - 1

        return res