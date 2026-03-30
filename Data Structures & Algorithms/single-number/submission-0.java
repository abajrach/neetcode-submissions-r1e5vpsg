class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int n: nums) {
            if (!seen.add(n)) {
                seen.remove(n);
            }
        }
        return seen.size() == 1 ? seen.iterator().next() : -1;
    }
}
