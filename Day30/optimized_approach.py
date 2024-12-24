class Solution:
    def search(self,arr,key):
        low, high = 0, len(arr) - 1
        
        while low <= high:
            
            mid = (low + high) // 2

            if arr[mid] == key:
                return mid

            elif arr[mid] < arr[high]:
                if key > arr[mid] and key <= arr[high]:
                    low = mid + 1
                else:
                    high = mid - 1
                        
            else:
                if key < arr[mid] and key > arr[high]:
                    high = mid - 1
                else:
                    low = mid + 1

        return -1
