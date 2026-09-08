class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0, ones = 0;
        for (int n: nums) {
            if (n == 1) {
                ones++;
            } else {
                res = Math.max(res, ones);
                ones = 0;
            }
        }
        return Math.max(res, ones);
    }
}