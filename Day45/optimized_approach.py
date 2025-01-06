class Solution:
    def intersectionWithDuplicates(self, a, b):
        # Optimized Approach
        
        # Initialize an empty hashmap for list a
        a_map = {}
        
        # Iterate through each element of a
        for el in a:
            
            # Update the element in hashmap
            # with default value as false
            a_map[el] = False
            
        # Iterate through each element of b
        for el in b:
            
            # Check if element exists in hashmap
            if a_map.get(el) != None:
                
                # If exists update the value to true
                a_map[el] = True
        
        # Initialize the output list of intersection
        out = []

        # Iterate through the hashmap
        for el, flag in a_map.items():
            
            # If the value is true then
            # update it in the ouput list
            if flag:
                out.append(el)
        
        # Return the output list after iteration
        return out
