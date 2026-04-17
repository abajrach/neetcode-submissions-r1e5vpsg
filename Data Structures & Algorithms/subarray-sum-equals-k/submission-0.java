class Solution {

    // Most naive solution
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int runningSum = 0;
            for (int j = i; j < nums.length; j++) {
                runningSum += nums[j];
                if (runningSum == k) res++;
            }
        }
        return res;
    }
}