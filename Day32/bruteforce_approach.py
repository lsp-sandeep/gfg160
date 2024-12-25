class Solution:

    def kthElement(self, left, right, k):

        # Better Approach
        l_len, r_len = len(left), len(right)
        
        l, r = 0, 0
        
        res = float('inf')
        
        for _ in range(k):
            
            if l < l_len and r < r_len:
                
                if left[l] < right[r]:
                    res = left[l]
                    l += 1
                else:
                    res = right[r]
                    r += 1
            
            elif l < l_len:
                
                res = left[l]
                l += 1
            
            else:
                
                res = right[r]
                r += 1

        return res
        