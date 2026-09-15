class Solution {
    public int heightChecker(int[] heights) {
        /*
            1,1,4,2,1,3
            1,1,1,2,3,4
                *.  * *

              3 1 1 1
            0 1 2 3 4 ... 100
        */

        // int[] expected = Arrays.copyOf(heights, heights.length);
        // Arrays.sort(expected);

        int[] freq = new int[101];
        for (int n: heights) {
            freq[n]++;
        }
        int[] expected = new int[heights.length];
        int k = 0;
        for (int i = 1; i <= 100; i++) {
            while (freq[i] > 0) {
                expected[k++] = i;
                freq[i]--;
            }
        }

        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            if (expected[i] != heights[i]) {
                res++;
            }
        }

        return res;
    }
}