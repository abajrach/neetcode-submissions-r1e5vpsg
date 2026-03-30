class Solution {

    private int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    // DFS. O (m * n)
    // Start from the four edges of the board (2 pacific and 2 atl)
    // If water can flow from edges to the inward, it means it can flow outward to the ocean as well.
    // Use two boolean 2D arrays to determine pac and atl oceans. for a cell, if both are true, then add to result.
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length, COLS = heights[0].length;
        
        boolean pac[][] = new boolean[ROWS][COLS];
        boolean atl[][] = new boolean[ROWS][COLS];

        for (int c = 0; c < COLS; c++) {
            dfs(0, c, pac, heights);        // first row
            dfs(ROWS - 1, c, atl, heights); // last row
        }

        for (int r = 0; r < ROWS; r++) {
            dfs(r, 0, pac, heights);        
            dfs(r, COLS - 1, atl, heights);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (pac[r][c] && atl[r][c]) {
                    result.add(Arrays.asList(r,c));
                }
            }
        }
        return result;
    }

    private void dfs(int r, int c, boolean[][] ocean, int[][] heights) {
        ocean[r][c] = true;

        for (int[] dir: directions) {
            int nr = r + dir[0], nc = c + dir[1];
            if (nr >= 0 && nc >= 0 && nr < heights.length && nc < heights[0].length 
                && !ocean[nr][nc] 
                && heights[nr][nc] >= heights[r][c]) {
                dfs(nr, nc, ocean, heights);
            }
        }
    }
}
