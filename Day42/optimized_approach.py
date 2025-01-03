class Solution:
    def twoSum(self, arr, target):
        # Optimized Approach
        
        n = len(arr)
        aux_map = {}
        
        for i in range(n):
            diff = target - arr[i]
            
            if diff >= 0 and aux_map.get(diff, -1) >= 0:
                return True
            else:
                aux_map[arr[i]] = i
        
        return False
