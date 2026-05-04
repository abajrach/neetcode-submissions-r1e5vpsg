class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;

        int res = 1;
        for (int n = 1; n <= x; n++) {
            if ((long) n * n > x) {
                return res;
            }
            res = n;
        }
        return res;
    }
}