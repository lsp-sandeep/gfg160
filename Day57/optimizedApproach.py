
class optimizedApproach:
    # Optimized Approach
    def countDistinct(self, arr, k):
        '''
        The following function counts the distinct elements in a
        given array arr[] for every window of size k
        '''    
        
        # Initialize the frequency hashmap and the resultant counts
        freq, res = {}, []
        
        # Update the frequencies for the first k elements
        for i in range(k):
            freq[arr[i]] = freq.get(arr[i], 0) + 1
        
        # Initialize the count of array and the hashmap
        n, count = len(arr), len(freq)

        # Append the count of first window to the resultant array
        res.append(count)

        # Initialize the left and right pointers to first and kth index
        left, right = 0, k - 1

        # Iterate while the right pointer is less than array length
        while right < n - 1:
            # Decrease the frequency of element at left pointer
            freq[arr[left]] -= 1
            
            # If the frequency of the above element is 0
            if freq[arr[left]] == 0:
                # then decrease the count and remove the element
                count -= 1; del freq[arr[left]]

            # Increment the left and right pointer by 1
            left += 1; right += 1
            
            # Increment the count if the element at right pointer is new
            count += int(arr[right] not in freq)

            # Increment the frequency of the above element by 1
            freq[arr[right]] = freq.get(arr[right], 0) + 1

            # Append the count to the resultant array
            res.append(count)

        # Return the resultant array at the end of iteration
        return res