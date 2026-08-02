class Solution {
    // Using hashmap. Extra space
    public int removeDuplicates(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        int k = 0;
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
            if (count.get(n) <= 2) {
                nums[k++] = n;
            }
        }
        return k;
    }
}