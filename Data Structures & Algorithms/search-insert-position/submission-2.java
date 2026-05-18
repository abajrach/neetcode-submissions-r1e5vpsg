class Solution {
    public int searchInsert(int[] nums, int target) {
        // -1,0,2,4,6,8         t = 5
        //  0 1 2 3 4 5
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
                // -1 0 2 4 6 8.    t = 1
                //    r
                //    l 
            } else {
                return mid;
            }
        }
        return l;
    }
}