class Solution {
    public int maxArea(int[] heights) {
        int result = 0;

        int l = 0, r = heights.length - 1;

        while (l < r) {
            result = Math.max(result, (Math.min(heights[l], heights[r]) * (r - l)));

            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }

        return result;
    }
}
