class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap 
            = new PriorityQueue<>(Collections.reverseOrder());
        for (int n: stones) {
            maxHeap.offer(n);
        }

        while(maxHeap.size() > 1) {
            int s1 = maxHeap.poll();
            int s2 = maxHeap.poll();

            if (s1 - s2 > 0) {
                maxHeap.offer(s1-s2);
            }
        }
        maxHeap.offer(0);
        return maxHeap.peek();
    }
}
