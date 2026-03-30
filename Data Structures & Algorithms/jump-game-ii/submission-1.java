class Solution {
    public int jump(int[] nums) {
        int l = 0, r = 0, res = 0;

        // Edge. We dont need to jump from last position
        while (r < nums.length - 1) {
            int farthest = 0;
            for (int i = l; i <= r; i++) {
                farthest = Math.max(farthest, nums[i] + i);
            }
            l = r + 1;
            r = farthest;
            res++;
        }

        return res;
    }
}
