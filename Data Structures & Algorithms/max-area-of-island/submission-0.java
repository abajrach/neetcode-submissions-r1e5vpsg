class Solution {

    private static final int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    
    // DFS
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, r, c));
                }
            }
        }
        return maxArea;    
    }

    private int dfs(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0) {
            return 0;
        }

        grid[r][c] = 0;
        int res = 1;

        for (int[] d: directions) {
            res += dfs(grid, r + d[0], c + d[1]);
        }

        return res;
    }
}
