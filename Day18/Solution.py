# Python program to search the pattern in given text 
# using KMP Algorithm
#%%
def constructLps(pat, lps):
    
    # len stores the length of longest prefix which 
    # is also a suffix for the previous index
    len_ = 0
    m = len(pat)
    
    # lps[0] is always 0
    lps[0] = 0

    i = 1
    while i < m:
        print(lps)
        # If characters match, increment the size of lps
        if pat[i] == pat[len_]:
            len_ += 1
            lps[i] = len_
            i += 1
        
        # If there is a mismatch
        else:
            if len_ != 0:
                
                # Update len to the previous lps value 
                # to avoid redundant comparisons
                len_ = lps[len_ - 1]
            else:
                
                # If no matching prefix found, set lps[i] to 0
                lps[i] = 0
                i += 1

def search(pat, txt):
    n = len(txt)
    m = len(pat)

    lps = [0] * m
    res = []

    constructLps(pat, lps)

    print(lps)

    # Pointers i and j, for traversing 
    # the text and pattern
    i = 0
    j = 0

    while i < n:

        # If characters match, move both pointers forward
        if txt[i] == pat[j]:
            i += 1
            j += 1

            # If the entire pattern is matched 
            # store the start index in result
            if j == m:
                res.append(i - j)
                
                # Use LPS of previous index to 
                # skip unnecessary comparisons
                j = lps[j - 1]
        
        # If there is a mismatch
        else:
            
            # Use lps value of previous index
            # to avoid redundant comparisons
            if j != 0:
                j = lps[j - 1]
            else:
                i += 1
    return res 

#%%

#User function Template for python3

class Solution:
    @classmethod
    def createLPS(self, pat):
        
        pat_len = len(pat)
        
        lps = [0] * pat_len
        print(pat)
        
        lps_idx, pat_idx = 0, 1
        
        while pat_idx < pat_len:
            print(lps)
            print(pat[pat_idx], lps[lps_idx])

            if pat[pat_idx] == pat[lps_idx]:
                print("here")
                lps_idx += 1
                
                lps[pat_idx] = lps_idx
                
                pat_idx += 1
            
            elif lps_idx != 0:
                print("here")
                lps_idx = lps[lps_idx - 1]
                
            else:
                lps[pat_idx] = 0
                
                pat_idx += 1

        return lps
            

    def search(self, pat, txt):
        # Bruteforce Approach
        # output = []
        
        # if len(pat) > len(txt):
        #     return output
        
        # for i in range(len(txt) - len(pat) + 1):
        #     match = 1
        #     for j in range(len(pat)):
                
        #         if txt[i + j] != pat[j]:
        #             match = 0
        #             break
            
        #     if match == 1:
        #         output.append(i)
        
        # return output
        
        # KMP Algorithm
        
        txt_len, pat_len = len(txt), len(pat)
        
        lps = Solution.createLPS(pat)
        print(lps)
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
        


#%%

txt = "aabaacaadaabaaba"
pat = "aaba"

res = search(pat, txt)
ob = Solution()
ans = ob.search(pat, txt)

for i in range(len(res)):
    print(res[i], end=" ")

print()

for i in range(len(ans)):
    print(ans[i], end=" ")

#%%