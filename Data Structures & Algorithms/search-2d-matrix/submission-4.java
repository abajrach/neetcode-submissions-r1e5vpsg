class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        /*
            [[1,2, 4,  8],
            [10,11,12,13],
            [14,20,30,40]]

        */
        int ROWS = matrix.length, COLS = matrix[0].length;
        int l = 0, r = ROWS * COLS - 1;
        while (l <= r) {
            int mid = l + ((r - l) / 2);
            int row = mid / COLS, col = mid % COLS;
            if (matrix[row][col] < target) {
                l = mid + 1;
            } else if (matrix[row][col] > target) {
                r = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
