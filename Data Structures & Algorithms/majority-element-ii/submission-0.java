class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Set<Integer> result = new HashSet<>();
        
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
            if (count.get(n) > (nums.length / 3)) {
                result.add(n);
            }
        }

        return new ArrayList<>(result);
    }
}