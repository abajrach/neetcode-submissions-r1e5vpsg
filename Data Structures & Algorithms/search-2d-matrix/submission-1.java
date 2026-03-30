class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Staircase Search. O(m + n)
        int m = matrix.length, n = matrix[0].length;
        int r = 0, c = n - 1;

        while (r < m && c >= 0) {
            if (matrix[r][c] < target) {
                r++;
            } else if (matrix[r][c] > target) {
                c--;
            } else {
                return true;
            }
        }

        return false;
    }
}
