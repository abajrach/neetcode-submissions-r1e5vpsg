class Solution {
    public int[] sortedSquares(int[] nums) {
        int l = 0, r = nums.length - 1, k = nums.length - 1;
        int[] result = new int[nums.length];
        while (l <= r) {
            if (Math.abs(nums[l]) < Math.abs(nums[r])) {
                result[k--] = nums[r] * nums[r];
                r--;
            } else {
                result[k--] = nums[l] * nums[l];
                l++;
            }
        }
        return result;
    }
}