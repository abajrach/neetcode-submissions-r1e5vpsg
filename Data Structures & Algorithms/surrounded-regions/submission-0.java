class Solution {
    /*
        ["X","X","X","X"],
        ["X","O","O","X"],
        ["X","O","O","X"],
        ["X","X","X","O"]
    */

    // BFS approach. O(m * n)
    private static final int[][] directions = {{1,0}, {-1,0}, {0,1},{0,-1}};

    public void solve(char[][] board) {
        capture(board);

        // 3) Now, flip all the O's to X's and T's back to O's.
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == 'T') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    // 1) Determine O's that are in the boundaries and put them in queue.
    // 2) Do BFS traversal from queue items and mark the grids are safe ('T') in 4 directions
    private void capture(char[][] board) {
        Queue<int[]> q = new LinkedList<>();

        for (int r = 0; r < board.length; r++){
            for (int c = 0; c < board[0].length; c++) {
                if ((r == 0 || r == board.length - 1 || c == 0 || c == board[0].length - 1) && (board[r][c] == 'O')) {
                    q.offer(new int[] {r, c});
                }
            }
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int row = cur[0], col = cur[1];

            if (board[row][col] == 'O') {
                board[row][col] = 'T';

                for (int[] dir: directions) {
                    int nr = row + dir[0], nc = col + dir[1];
                    if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length) {
                        q.offer(new int[] {nr, nc});
                    }
                }
            }

        }
    }
}
