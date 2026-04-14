class Solution {

    /*
       [["1","2",".",".","3",".",".",".","."],
        ["4",".",".","5",".",".",".",".","."],
        [".","9","8",".",".",".",".",".","3"],
        ["5",".",".",".","6",".",".",".","4"],
        [".",".",".","8",".","3",".",".","5"],
        ["7",".",".",".","2",".",".",".","6"],
        [".",".",".",".",".",".","2",".","."],
        [".",".",".","4","1","9",".",".","8"],
        [".",".",".",".","8",".",".","7","9"]]
    */

    // O(n^2) single pass solution
    public boolean isValidSudoku(char[][] board) {

        Map<Integer, Set<Character>> rows = new HashMap();
        Map<Integer, Set<Character>> cols = new HashMap();
        Map<String, Set<Character>> squares = new HashMap(); // key is like "1,2" which is row 1, col 2

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') continue;

                String squareKey = (r / 3) + "," + (c / 3);
                if (rows.computeIfAbsent(r, (k) -> new HashSet<>()).contains(board[r][c]) 
                 || cols.computeIfAbsent(c, (k) -> new HashSet<>()).contains(board[r][c])
                 || squares.computeIfAbsent(squareKey, (k) -> new HashSet<>()).contains(board[r][c])) {
                    return false; // Duplicate found
                }

                rows.get(r).add(board[r][c]);
                cols.get(c).add(board[r][c]);
                squares.get(squareKey).add(board[r][c]);
            }
        }

        return true;
    }
}
