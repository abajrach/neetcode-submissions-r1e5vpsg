class Solution {

    private static final int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    // BFS. O(m*n)
    public int numIslands(char[][] grid) {

        int islands = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    bfs(grid, r, c);
                    islands++;
                }
            }
        } 

        return islands;
    }

    private void bfs(char[][] grid, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {r, c});
        
        grid[r][c] = '0';

        while(!q.isEmpty()) {
            int[] node = q.poll();
            int row = node[0], col = node[1];

            for (int[] d: dir) {
                int nr = row + d[0], nc = col + d[1];

                if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == '1') {
                    q.add(new int[] {nr, nc});
                    grid[nr][nc] = '0';
                }
            }
        }
    }
}
