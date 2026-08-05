class Solution {

    // O(n) for time and space complexity. Using extra array
    public int[] rearrangeArray(int[] nums) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for (int n: nums) {
            if (n > 0) { // pos
                pos.add(n);
            } else {
                neg.add(n);
            }
        }
        int i = 0;
        while (i < nums.length / 2) {
            nums[i * 2] = pos.get(i);
            nums[i * 2 + 1] = neg.get(i);
            i++;
        }
        return nums;
    }
}