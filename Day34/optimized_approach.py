class Solution:
    # Optimized Approach
    def check(self, arr, page_limit, k):
        
        page_sum = 0
        count = 1
        
        for pages in arr:
            
            if page_sum + pages > page_limit:
                count += 1
                page_sum = pages
            else:
                page_sum += pages

        return count <= k

    def findPages(self, arr, k):
        n = len(arr)

        if k > n:
            return -1
            
        low, high = max(arr), sum(arr)

        res = -1

        while low <= high:
            mid = low + (high - low) // 2

            check_res = self.check(arr, mid, k)

            if check_res:
                res = mid
                high = mid - 1
            else:
                low = mid + 1
        
        return res
