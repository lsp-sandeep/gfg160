package Day40;

class Solution {
    // Function to search a given number in row-column sorted matrix.
    public boolean searchMatrix(int[][] mat, int x) {
        // Optimize Approach
        
        // Initialize the row and column lengths of the matrix
        int rows = mat.length, cols = mat[0].length;
        
        // Initialize the least and highest cumulative element index
        int low = 0, high = (rows * cols) - 1;
        
        // Binary search algorithm to search using cumulative index
        // Iterate as long as the lower index is less than or equal
        // to the higher index of search limits
        while(low <= high) {
            
            // Initialize and update the middle index of search limits
            int mid = low + (high - low) / 2;
            
            // Decompose the cumulative middle index
            // into the row and column index
            int r_mid = mid / cols, c_mid = mid % cols;
            
            // Update the lower and higher limits by comparing the
            // element at middle index with the search value
            if(x > mat[r_mid][c_mid]) {

                // if middle element is lower then update
                // the lower index next to the middle element
                low = mid + 1;

            } else if(x < mat[r_mid][c_mid]) {

                // if middle element is higher then update
                // the higer index previous to the middle element
                high = mid - 1;

            } else {
                
                // If equal then element is found so return true
                return true;
            }
        }
        
        // If not found after iteration then return false
        return false;
    }
}
