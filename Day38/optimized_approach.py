class Solution:
    def matSearch(self, mat, x):

        # Initialize row and column lengths
        rows, cols = len(mat), len(mat[0])

        # Initialize two pointers for
        # row and col index to first row and last column
        r, c = 0, cols - 1

        # Iterate the array while
        # row and column indices are within limit
        while r < rows and c >= 0:

            # Compare the element at current index

            # If lesser then increase the row index
            if mat[r][c] < x:
                r += 1

            # If greater then decrease the col index
            elif mat[r][c] > x:
                c -= 1

            # If equal then return true
            else:
                return True

        return False
