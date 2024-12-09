class Solution:
    
    def nonRepeatingChar(self,s):
        # Frequency Array:
        aux = [-1] * 26
        
        for i in range(len(s)):
            hsh = ord(s[i]) - ord('a')
            if aux[hsh] == -1:
                aux[hsh] = i
            elif aux[hsh] > -1:
                aux[hsh] = -2
        
        min_idx = len(s)
        for a in aux:
            if a < min_idx and a > -1:
                min_idx = a
        
        if min_idx == len(s):
            return '$'
        
        return s[min_idx]