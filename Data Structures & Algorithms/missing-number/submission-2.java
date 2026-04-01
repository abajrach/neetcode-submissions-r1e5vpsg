class Solution {

    // Sorting approach
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i <= nums.length; i++) {
            if (nums.length <= i || i != nums[i]) {
                return i;
            }
        }
        return -1;
    }
}
