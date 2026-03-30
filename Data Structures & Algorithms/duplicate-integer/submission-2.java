class Solution {
    public boolean hasDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return false;

        Set<Integer> seenSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(!seenSet.add(nums[i])) {
                return true;
            }
        }

        return false;
    }
}