package Day39;

class Solution {
    
    // Binary search algorith to search element in an array
    public boolean search(int[] row, int x) {
        
        // Initialize the length of the array
        int cols = row.length;
        
        // Initialize the low and high pointers
        // to the first and last index of the array
        int low = 0, high = cols - 1;
        
        // Iterate while the low index is less or
        // equal to the high index
        while(low <= high) {
            
            // Initialize the mid index to
            // the midpoint of low and high
            int mid = low + (high - low) / 2;
            
            // Compare the mid element with x
            if(row[mid] < x) {
                
                // If the mid element is lesser
                // Update the low index to mid index + 1
                low = mid + 1;
    
            } else if(row[mid] > x) {
    
                // If the mid element is higher
                // Update the high index to mid index - 1
                high = mid - 1;
            } else {
                
                // If equal then return true
                return true;
            }
        }
        
        // If not found a match return false
        return false;
    }
    
    public boolean searchRowMatrix(int[][] mat, int x) {
        // Optimized Approach
        
        // Initialize the length of rows and columns of matrix
        int rows = mat.length;
        
        // Iterate each row of the matrix
        for(int row = 0; row < rows; row++) {
            
            // Search for the element in the current row
            if(search(mat[row], x)) {
                
                // Return true if the element is found
                return true;
            }
        }
        
        // If not found a match in any row return false
        return false;
    }
}
