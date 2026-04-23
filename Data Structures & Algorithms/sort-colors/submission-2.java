class Solution {
    public void sortColors(int[] nums) {
        int zeros = 0, ones = 0, twos = 0;

        for (int n: nums) {
            if (n == 0) zeros++;
            else if (n == 1) ones++;
            else if (n == 2) twos++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (zeros-- > 0) nums[i] = 0;
            else if (ones-- > 0) nums[i] = 1;
            else if (twos-- > 0) nums[i] = 2;
        }
    }
}