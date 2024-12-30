class Solution {
    static void rotateby90(int mat[][]) {
        // Optimized Approach
        int n = mat.length;
        
        // Iterate from the outer most layer to the center
        for(int row = 0; row < (n / 2) + 1; row++) {
            
            // Iterate each element in the layer
            for(int col = row; col < n - row - 1; col++) {
                
                // Store the element from each side of the layer
                int top = mat[row][col];
                int right = mat[col][n - row - 1];
                int bottom = mat[n - row - 1][n - col - 1];
                int left = mat[n - col - 1][row];
                
                // Modify the element with the element of the next side
                mat[row][col] = right;
                mat[col][n - row - 1] = bottom;
                mat[n - row - 1][n - col - 1] = left;
                mat[n - col - 1][row] = top;
            }
        }
        
        return;
    }
}