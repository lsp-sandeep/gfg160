#User function Template for python3
#Function to count inversions in the array.

class Solution:
    def inversionCount(self, arr):
        # Bruteforce Approach
        n = len(arr)
        count = 0
        for i in range(n - 1):
            for j in range(i + 1, n):
                if arr[i] > arr[j]:
                    count += 1
        return count

