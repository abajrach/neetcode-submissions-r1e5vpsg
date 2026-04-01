class Solution {
    public int hammingWeight(int n) {
        int ones = 0;
        while (n != 0) {

            // Modding by 2 tells if the rightmost digit of a number is 1 or 0.
            // 0 % 2 = 0
            // 1 % 2 = 1
            if (n % 2 == 1) {
                ones++;
            }
            // Right shift by one
            n = n >> 1;
        }
        return ones;
    }
}
