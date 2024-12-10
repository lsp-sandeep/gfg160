class Solution:
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
