class Solution {
    /* 
        2,3,6,2,4
    */
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int n: stones) {
            maxHeap.offer(n);
        }

        while (maxHeap.size() > 1) {
            int a = maxHeap.poll();
            int b = maxHeap.poll();
            
            if (a == b) continue;
            
            maxHeap.offer(a - b);
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}
