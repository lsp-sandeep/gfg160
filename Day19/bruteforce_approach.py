class Solution:
    def minChar(self, s):
        #Bruteforce Approach
        left, right = 0, len(s) - 1
        
        add, match = 0, 0
        
        while left <= right:

            if s[left] == s[right]:
                match += 1
                left += 1
                right -= 1
            else:
                add += 1
                left = 0
                right += match - 1
                match = 0

        return add
