class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry: count.entrySet()) {
            if (entry.getValue() > (nums.length / 3)) {
                result.add(entry.getKey());
            }
        }

        return result;
    }
}