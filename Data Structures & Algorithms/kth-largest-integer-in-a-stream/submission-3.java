class KthLargest {

    private PriorityQueue<Integer> minHeap;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();

        for (int n: nums) {
            minHeap.offer(n);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        /*
            1 2 3 3 3 5 6 7 8

            1 2 3 3, k = 3,  [1 2 3 ]
        */
        minHeap.offer(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }

        return minHeap.peek();
    }
}
