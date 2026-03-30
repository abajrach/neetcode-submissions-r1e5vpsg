class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {          // fresh fruit
                    fresh++;
                } else if (grid[r][c] == 2) {   // rotten fruit
                    q.offer(new int[]{ r,c });
                }
            }
        }

        int time = 0;

        // Edge case: fresh > 0 is needed because fruits are being added to queue after infecting them.
        // So, queue might still hold some fruits but all the fruits have been infected
        while (fresh > 0 && !q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int row = cur[0], col = cur[1];

                for (int[] dir: directions) {
                    int nr = row + dir[0], nc = col + dir[1];

                    if (nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length || grid[nr][nc] != 1) {
                        continue;
                    }
                    grid[nr][nc] = 2;
                    q.offer(new int[] {nr, nc});
                    fresh--;
                }
            }
            time++;
        }

        return fresh == 0 ? time : -1;
    }
}
