class Solution:
    def hIndex(self, citations):
        # Optimized Approach
        n = len(citations)
        aux = [0] * (n + 1)
        
        for i in range(n):
            if citations[i] > n:
                aux[n] += 1
            else:
                aux[citations[i]] += 1
        
        count = 0
        for i in range(n, -1, -1):
            count += aux[i]
            if count >= i:
                return i
        
        return 0
