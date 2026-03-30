class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        // we need to check for <= rather than just < because
        // in edge case when we are down to last element, both l and r are equal
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
