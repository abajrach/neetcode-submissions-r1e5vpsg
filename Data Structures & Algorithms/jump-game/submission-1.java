class Solution {
    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {

            // If we can reach the goal, update the goal.
            // Idea is to reach from end of the array to 0th position.
            if (nums[i] + i >= goal) {
                goal = i;
            }
        }
        return goal == 0;
    }
}
