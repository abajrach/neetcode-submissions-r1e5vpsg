class Solution {
    /* 
        2,2,3,4,6
    */
    // Sorting. O(n^2 * logn)
    public int lastStoneWeight(int[] stones) {
       List<Integer> stoneList = new ArrayList<>();
       for (int n : stones) {
            stoneList.add(n);
       }

       while (stoneList.size() > 1) {
            Collections.sort(stoneList);
            int a = stoneList.remove(stoneList.size() - 1);
            int b = stoneList.remove(stoneList.size() - 1);

            if (a != b) {
                stoneList.add(a - b);
            }
       }

       return stoneList.isEmpty() ? 0 : stoneList.get(0);
    }
}
