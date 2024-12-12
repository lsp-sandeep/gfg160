#%%
#User function Template for python3

class Solution:
    
    #Function to check if two strings are rotations of each other or not.
    def areRotations(self,s1,s2):
        #code here
        n = len(s1)
        
        i, j = 0, 0
        match = 0
        while i < n:
            print(i, j, s1[i], s2[j], match)
            
            if s1[i] == s2[j]:
                i += 1
                j = (j + 1) % n
                match += 1
            elif match > 0 and j < n:
                i = 0
                match = 0
            elif match == 0 and j < n:
                i = 0
                j = (j + 1) % n
                match = 0
            else:
                return False
        
        # print(i, j, s1[i], s2[j], match)

        if match == n:
            return True
        
        return False

#%%
s1 = "ohbrwzxvxe"
s2 = "uornhegseo"
if (Solution().areRotations(s1, s2)):
    print("true")
else:
    print("false")

#%%
