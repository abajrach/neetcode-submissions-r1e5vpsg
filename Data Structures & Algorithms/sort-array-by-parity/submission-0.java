class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int l = 0, r = 0;
        while (r < nums.length) {
            if (nums[r] % 2 == 0) { // Even
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
            }
            r++;
        }
        return nums;
    }
}