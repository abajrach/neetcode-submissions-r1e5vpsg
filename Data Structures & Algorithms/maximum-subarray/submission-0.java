class Solution {

    // Brute force. O(n^2)
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int cur = 0;
            for (int j = i; j < nums.length; j++) {
                cur += nums[j];
                res = Math.max(res, cur);
            }
        }

        return res;
    }
}
