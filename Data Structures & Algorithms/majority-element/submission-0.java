class Solution {
    public int majorityElement(int[] nums) {
        int maxCount = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
            if (count.get(n) > (nums.length / 2)) {
                // System.out.println(count.get(n));
                return n;
            }
        }
        return -1;
    }
}