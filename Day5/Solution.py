#%%
def permutations(res, arr, idx):
    
    # Base case: if idx reaches the end of the list
    if idx == len(arr) - 1:
        res.append(arr[:])
        print("Base Case: ", idx, arr, res)
        return

    # Generate permutations by swapping each
    # element starting from index `idx`
    for i in range(idx, len(arr)):
        
        # Swapping
        arr[idx], arr[i] = arr[i], arr[idx]
        print("Entry: ", idx, i, arr, res)
        # Recursive call to create permutations 
        # for the next element
        permutations(res, arr, idx + 1)
        print("Exec: ", idx, i, arr, res)

        # Backtracking
        arr[idx], arr[i] = arr[i], arr[idx]
        print("Exit: ", idx, i, arr, res)

#%%
# Driver code
arr = [1, 3, 2]
res = []
permutations(res, arr, 0)
print(res)

#%%

from IPython.display import clear_output
import time
for i in range(100):
    clear_output(wait=True)
    print(f"{i}/{10}: {(i/10)*100}%")
    time.sleep(10)

#%%