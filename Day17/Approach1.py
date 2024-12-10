class Solution:
    
    def nonRepeatingChar(self,s):
        # Hashmap Two Iterations:
        aux = {}
        
        for l in s:
            aux[l] = aux.get(l, 0) + 1
            
        for l in s:
            if aux[l] == 1:
                return l

        return '$'
