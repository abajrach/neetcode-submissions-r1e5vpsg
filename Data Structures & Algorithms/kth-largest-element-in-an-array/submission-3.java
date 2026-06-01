class Solution {
    // minHeap
    public int findKthLargest(int[] nums, int k) {
        // [1,1,2,3,4,5,5] k = 3, ans = 4
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int n: nums) {
            minHeap.offer(n);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}
