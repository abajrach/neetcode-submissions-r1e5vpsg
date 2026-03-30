class Solution {
    private static final int INF = 2147483647;
    private static final int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public void islandsAndTreasure(int[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == INF) {
                    grid[r][c] = bfs(grid, r, c);
                }
            }
        }
    }

    private int bfs(int[][] grid, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {r,c});

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[r][c] = true;

        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int row = cur[0], col = cur[1];

                if (grid[row][col] == 0) return steps; 

                for (int[] dir: directions) {
                    int nr = row + dir[0], nc = col + dir[1];

                    if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && !visited[nr][nc] && grid[nr][nc] != -1) {
                        visited[nr][nc] = true;
                        q.offer(new int[] {nr, nc});
                    }
                }
            }
            steps++;
        }

        return INF;
    }
}
