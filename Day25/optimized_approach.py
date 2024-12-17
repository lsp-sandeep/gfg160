class Solution:
    def insertInterval(self, intervals, newInterval):
        # Naive Approach
        res = []
        n = len(intervals)
        
        new_start, new_end = newInterval[0], newInterval[1]
        inserted = False
        for i in range(n):
            start, end = intervals[i][0], intervals[i][1]

            if (not inserted) and new_end < start:
                res.extend([[new_start, new_end], intervals[i]])
                inserted = True
            elif new_end < start or new_start > end:
                res.extend([intervals[i]])
            elif new_end <= end:
                new_start, new_end = min(new_start, start), end
                res.extend([[new_start, new_end]])
                inserted = True
            elif new_start <= end:
                new_start = min(new_start, start)

        if not inserted:
            res.extend([[new_start, new_end]])
            
        return res