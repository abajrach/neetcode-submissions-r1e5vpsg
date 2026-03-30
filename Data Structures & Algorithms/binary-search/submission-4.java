class Solution {
    public int search(int[] nums, int target) {
        return dfs(nums, 0, nums.length - 1, target);
    }

    private int dfs(int[] nums, int l, int r, int target) {
        if (l > r) return -1; // base case

        int m = l + (r - l) / 2;
        if (nums[m] == target) return m;

        if (nums[m] < target) {
            return dfs(nums, m + 1, r, target);
        } else {
            return dfs(nums, l, r - 1, target);
        }
    }    
}
