class Solution:
    def hIndex(self, citations):

        # Naive Approach
        citations.sort()
        
        n = len(citations)
        h_idx = 0
        
        for i in range(n - 1, -1, -1):
            
            if n - i > citations[i]:
                break

            h_idx = n - i
    
        return h_idx