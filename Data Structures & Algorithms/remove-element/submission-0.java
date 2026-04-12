class Solution {
    // Input: nums = [1,1,2,3,4], val = 1
    // Two pointers. O(n)
    public int removeElement(int[] nums, int val) {
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}