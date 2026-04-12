class Solution {
    // Input: nums = [1,1,2,3,4], val = 1
    // Two pointers II O(n) More Efficient
    /**
        [4,3,2,3,4]
             i   n
    */
    // Output: []
    public int removeElement(int[] nums, int val) {
        int i = 0, n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[--n];
            } else {
                i++;
            }
        }
        
        System.out.println(Arrays.toString(nums));
        return i;
    }
}