class Solution {

    private int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    private boolean[][] visited;

    public int islandPerimeter(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;

        this.visited = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    return dfs(grid, visited, r, c);
                }
            }
        }

        return 0;
    }

    private int dfs(int[][] grid, boolean[][] visited, int r, int c) {

        // Return 1 if we hit out of boundary or water
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0) {
            return 1;
        }

        if (visited[r][c]) {
            return 0;
        }

        visited[r][c] = true;
        
        int res = 0;

        for (int[] dir: directions) {
            res += dfs(grid, visited, r + dir[0], c + dir[1]);
        }
        return res;
    }
}