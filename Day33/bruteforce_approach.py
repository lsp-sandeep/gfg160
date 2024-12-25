
class Solution:
    # Naive Approach
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

        max_diff = stalls[-1] - stalls[0]
        
        max_min_diff, diff = 1, 1
        
        while diff <= max_diff:

            if self.check(stalls, diff, k):
                # print(diff, True)
                max_min_diff = diff

            diff += 1

        return max_min_diff

