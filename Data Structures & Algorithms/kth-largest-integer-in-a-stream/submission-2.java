class KthLargest {

    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();  
        for (int n: nums) {
            minHeap.offer(n);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }  
    }
    // O (m * logk) where m is number of calls made to add()
    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
