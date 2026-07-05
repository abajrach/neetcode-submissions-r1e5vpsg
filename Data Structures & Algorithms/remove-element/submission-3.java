class Solution {
    public int removeElement(int[] nums, int val) {
        List<Integer> temp = new ArrayList<>();

        for (int n: nums) {
            if (n != val) {
                temp.add(n);
            }
        }
        int j = 0;
        for (int n: temp) {
            nums[j++] = n;
        }
        return temp.size();
    }
}