class Solution:
    # Optimized Approach
    def productExceptSelf(self, arr):
        '''
        This function returns the product of all elements
        except itself for each element of the input array
        
        Approach:
        1. Calculate the product of all elements before each element
        2. For each element then multiply with all elements after it
        
        Time Complexity: O(n + n) = O(n)
        Space Complexity: O(1)
        '''
        # Initialize the length and result
        n = len(arr); res = [1] * n
        # Initialize the prefix and suffix product to 1
        prefix_prod, suffix_prod = 1, 1
        
        # Update the result array with the prefix product 
        for i in range(1, n):
            
            prefix_prod *= arr[i - 1]
            
            res[i] = prefix_prod
        
        # Update the result array by multiplying with suffix product
        for i in range(n - 2, -1, -1):
            
            suffix_prod *= arr[i + 1]
            
            res[i] *= suffix_prod
            
        return res
