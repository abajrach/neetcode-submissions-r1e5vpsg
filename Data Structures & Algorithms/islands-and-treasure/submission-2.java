class Solution {

    // DFS optimal solution using 0's (treasure) as starting point.
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0) {
                    q.offer(new int[] {r, c});
                }
            }
        }

        if (q.isEmpty()) return;

        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int row = cur[0], col = cur[1];
        
            for (int[] dir: directions) {
                int nr = row + dir[0], nc = col + dir[1];

                if (nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length || grid[nr][nc] != Integer.MAX_VALUE) {
                    continue;
                }

                grid[nr][nc] = grid[row][col] + 1;
                q.offer(new int[] {nr, nc});
            }
        }
    }
}
