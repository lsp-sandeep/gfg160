class Solution:
    def minRemoval(self, intervals):
        # Optimized Approach
        intervals.sort()
        
        n = len(intervals)
        count = 0
        end = intervals[0][1]
        for i in range(1, n):
            
            if intervals[i][0] < end:
                end = min(end, intervals[i][1])
                count += 1
            
            else:
                end = intervals[i][1]
                
        return count