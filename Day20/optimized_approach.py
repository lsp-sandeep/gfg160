#User function Template for python3
#Function to check if two strings are rotations of each other or not.

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

    @classmethod
    def search(self, pat, txt):
        # KMP Algorithm
        
        txt_len, pat_len = len(txt), len(pat)
        lps = Solution.createLPS(pat)
        res = []
        txt_idx, pat_idx = 0, 0
        
        while txt_idx < txt_len:
            
            if txt[txt_idx] == pat[pat_idx]:
                txt_idx += 1
                pat_idx += 1
                
                if pat_idx == pat_len:
                    res.append(txt_idx - pat_idx)
                    pat_idx = lps[pat_idx - 1]
            elif pat_idx != 0:
                pat_idx = lps[pat_idx - 1]
            else:
                txt_idx += 1

        return res

    def areRotations(self,s1,s2):
        #KMP Algorithm
        idxs = Solution.search(s1, s2 + s2)
        
        if len(idxs) > 0:
            return True
        
        return False
