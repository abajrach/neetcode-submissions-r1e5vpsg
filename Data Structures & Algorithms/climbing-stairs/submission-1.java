class Solution {
    public int climbStairs(int n) {
        // if (n <= 2) return n;

        /*
          n = 5

          0. 1. 2. 3. 5. 8.  -> num of ways to reach levels
          0, 1, 2, 3, 4, 5.  -> levels
        */
        // int[] dp = new int[n + 1];
        // dp[1] = 1; // 1 way to reach step 1
        // dp[2] = 2; // 2 ways to reach step 2. 1,1 and 2 steps

        // for (int i = 3; i <= n; i++) {
        //     dp[i] = dp[i - 1] + dp[i - 2];
        // }

        // return dp[n];


        int one = 1, two = 1;

        for (int i = 0; i < n - 1; i++) {
            int temp = one;
            one = one + two;
            two = temp;
        }

        return one;
    }
}
