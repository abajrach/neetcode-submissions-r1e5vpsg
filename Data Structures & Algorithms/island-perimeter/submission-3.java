class Solution {
    // Iterative solution
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;

        int res = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    res += (r + 1 >= rows || grid[r + 1][c] == 0) ? 1 : 0;
                    res += (c + 1 >= cols || grid[r][c + 1] == 0) ? 1 : 0;
                    res += (r - 1 < 0 || grid[r - 1][c] == 0) ? 1 : 0;
                    res += (c - 1 < 0 || grid[r][c - 1] == 0) ? 1 : 0;
                }
            }
        }

        return res;
    }
}