class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        
        for (int num = 1; num <= n; num++) {
            // res[i] = countOnes(i);
            for (int i = 0; i < 32; i++) {

                // Note: need to test against 0 instead of 1 because
                // for eg: (010) & (010) = (010). So, need to test if its != 0
                if ((num & (1 << i)) != 0) {
                    res[num]++;
                }
            }
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
