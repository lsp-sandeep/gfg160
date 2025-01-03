package Day41;

class Solution {
    public void setMatrixZeroes(int[][] mat) {
        // Initialize row and column lengths of the matrix
        int rows = mat.length, cols = mat[0].length;
        
        // Initialize the flag to set first column to 0
        int c0 = 1;
        
        // Iterate the matrix to identify the zero indicies
        for(int r = 0; r < rows; r++) {
            
            for(int c = 0; c < cols; c++) {
                
                // If the element is zero
                if(mat[r][c] == 0) {
                    
                    // Update the corresponding
                    // element in the first column to 0
                    mat[r][0] = 0;
                    
                    // If the current element is in first column
                    if(c == 0) {
                        
                        // Update the c0 flag to 0
                        c0 = 0;
                    } else {
                        
                        // Else update the corresponding
                        // element in the first row to 0
                        mat[0][c] = 0;
                    }
                }
            }
        }

        // Iterate through the matrix from the second row and column
        for(int r = 1; r < rows; r++) {
            for(int c = 1; c < cols; c++) {
                
                // Check if either the corresponding element
                // in the first row or column are zeroes
                if(mat[r][0] == 0 || mat[0][c] == 0) {
                    
                    // Update the current element to 0
                    mat[r][c] = 0;
                }
                
            }
        }

        // If the first row and column element is zero
        if(mat[0][0] == 0) {
            
            // Update all the element of the first row to zero
            for(int c = 0; c < cols; c++) {
                mat[0][c] = 0;
            }
        }

        // If the c0 flag is zero
        if(c0 == 0) {

            // Update all the element of the firs column to zero
            for(int r = 0; r < rows; r++) {
                mat[r][0] = 0;
            }
        }

        return;
    }
}
