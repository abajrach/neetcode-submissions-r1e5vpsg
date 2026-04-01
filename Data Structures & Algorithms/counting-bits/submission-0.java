class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        
        for (int i = 0; i <= n; i++) {
            res[i] = countOnes(i);
        }

        return res;
    }

    private int countOnes(int num) {
        int ones = 0;
        while (num > 0) {
            // Bitwise AND with 1 tells if its 1 or 0. 
            // Then bitwise shift right to get test next bit
            ones += (num & 1) == 1 ? 1 : 0;
            num >>= 1;
        }

        return ones;
    }
}
