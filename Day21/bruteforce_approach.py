class Solution:
    def sort012(self, arr):
        # Naive Approach
        n = len(arr)
        idx_0, idx_1, idx_2 = -1, -1, -1
        i = 0
        
        while i < n:
            if arr[i] == 0:
                if idx_1 > -1 or idx_2 > -1:
                    idx_0 += 1
                    arr[idx_0], arr[i] = arr[i], arr[idx_0]
                else:
                    idx_0 = i
                    i += 1
            elif arr[i] == 1:
                if idx_2 > -1:
                    if idx_1 > -1:
                        idx_1 += 1
                    else:
                        idx_1 = idx_0 + 1
                    arr[idx_1], arr[i] = arr[i], arr[idx_1]
                else:
                    idx_1 = i
                    i += 1
            elif arr[i] == 2:
                idx_2 = i
                i += 1
        
        return arr
