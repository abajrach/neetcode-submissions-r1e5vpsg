class Solution {

    // Sorting
    public int findKthLargest(int[] nums, int k) {
        // [1,1,2,3,4,5,5] k = 3, ans = 4
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
