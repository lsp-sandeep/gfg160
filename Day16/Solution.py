class Solution:
    
    def areAnagrams(self, s1, s2):
        #Hashmap Approach

        if len(s1) != len(s2):
            return False
            
        aux = {}
        
        for s in s1:
            aux[s] = aux.get(s, 0) + 1
        
        for s in s2:
            if aux.get(s, 0) == 0:
                return False
            else:
                aux[s] -= 1
        
        for s in aux:
            if aux[s] > 0:
                return False
        
        return True