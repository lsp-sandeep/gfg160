class Solution:
    @classmethod
    def createLPS(self, pat):
        
        pat_len = len(pat)
        lps = [0] * pat_len
        lps_idx, pat_idx = 0, 1
        
        while pat_idx < pat_len:
            
            if pat[pat_idx] == pat[lps_idx]:
                lps_idx += 1
                lps[pat_idx] = lps_idx
                pat_idx += 1
            
            elif lps_idx != 0:
                lps_idx = lps[lps_idx - 1]
                
            else:
                lps[pat_idx] = 0
                pat_idx += 1

        return lps
    
    def minChar(self, s):
        #KMP Algorithm
        r = s[::-1]
        
        lps = Solution.createLPS(s + "#" + r)

        return len(s) - lps[-1]
