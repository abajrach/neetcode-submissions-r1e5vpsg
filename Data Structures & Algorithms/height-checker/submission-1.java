class Solution {
    public int heightChecker(int[] heights) {
        /*
            1,1,4,2,1,3
            1,1,1,2,3,4
                *.  * *
        */

        int[] expected = Arrays.copyOf(heights, heights.length);
        Arrays.sort(expected);

        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            if (expected[i] != heights[i]) {
                res++;
            }
        }

        return res;
    }
}