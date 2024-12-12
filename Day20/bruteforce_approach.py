#User function Template for python3
#Function to check if two strings are rotations of each other or not.

class Solution:
    def areRotations(self,s1,s2):
        #Bruteforce Approach
        n = len(s1)
        i, j = 0, 0
        match, unmatch = 0, 0

        while i < n and unmatch < n:
            if s1[i] == s2[j]:
                i += 1
                j = (j + 1) % n
                match += 1
            else:
                j = (j - match + 1) % n
                i = 0
                match = 0
                unmatch += 1
        
        if match == n:
            return True
        
        return False
