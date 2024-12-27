class Solution:
    def kthMissing(self, arr, k):
        # Naive Approach

        i, p, miss = 0, 0, 0
        while i < len(arr) and miss < k:
            p += 1

            if arr[i] != p:
                miss += 1
            else:
                i += 1
            

        while miss < k:
            p += 1
            miss += 1

        return p
        