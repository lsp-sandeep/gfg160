class Solution:

    def mergeAndCount(self, arr, l, m, r):
        
        left, right = arr[l:m + 1], arr[m + 1:r + 1]
        left_len, right_len = len(left), len(right)
        l_idx, r_idx, i, count = 0, 0, l, 0
        

        while l_idx < left_len and r_idx < right_len:
            if left[l_idx] <= right[r_idx]:
                arr[i] = left[l_idx]
                l_idx += 1
            else:
                arr[i] = right[r_idx]
                r_idx += 1
                count += left_len - l_idx
            i += 1
        
        while l_idx < left_len:
            arr[i] = left[l_idx]
            l_idx += 1
            i += 1
        while r_idx < right_len:
            arr[i] = right[r_idx]
            r_idx += 1
            i += 1
        
        return count

    def invCount(self, arr, l, r):

        count = 0

        if l >= r:
            return count

        m = (r + l) // 2

        count += Solution.invCount(self, arr, l, m)
        count += Solution.invCount(self, arr, m + 1, r)
        count += Solution.mergeAndCount(self, arr, l, m, r)
        
        return count

    def inversionCount(self, arr):
        # Optimized Approach
        n = len(arr)

        return Solution.invCount(self, arr, 0, n - 1)

