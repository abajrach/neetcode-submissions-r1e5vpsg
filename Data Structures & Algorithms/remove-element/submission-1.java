class Solution {
    // Input: nums = [1,1,2,3,4], val = 1
    // Two pointers. O(n)
    public int removeElement(int[] nums, int val) {
        int i = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}