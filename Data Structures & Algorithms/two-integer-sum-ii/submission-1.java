class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> index = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (index.containsKey(target - numbers[i])) {
                return new int[] {index.get(target - numbers[i]) + 1, i + 1};
            }
            index.put(numbers[i], i);
        }

        return new int[0];
    }
}
