class Solution:

    def kthElement(self, left, right, k):

        # Optimized Approach
        l_len, r_len = len(left), len(right)
        
        l, r = 0, 0
        
        low = max(0, k - r_len)
        high = min(k, l_len)
        
        while low <= high:
            
            l_mid = low + (high - low) // 2
            r_mid = k - l_mid
            
            l_l = -float('inf') if l_mid == 0 else left[l_mid - 1]
            l_r = -float('inf') if r_mid == 0 else right[r_mid - 1]

            r_l = float('inf') if l_mid == l_len else left[l_mid]
            r_r = float('inf') if r_mid == r_len else right[r_mid]
            
            if l_l <= r_r and l_r <= r_l:
                
                return max(l_l, l_r)
            
            if l_l > r_r:
                
                high = l_mid - 1
            
            else:
                
                low = l_mid + 1
        
        return 0

