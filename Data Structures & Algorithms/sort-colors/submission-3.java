class Solution {
    public void sortColors(int[] nums) {
        int[] colors = new int[3];
        for (int n: nums) {
            colors[n]++;
        }

        int j = 0;
        for (int i = 0; i < 3; i++) {
            while(colors[i] > 0) {
                nums[j++] = i;
                colors[i]--;
            }
        }
    }
}