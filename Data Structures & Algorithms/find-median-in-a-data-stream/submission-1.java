class MedianFinder {

    private PriorityQueue<Integer> smallHeap; // maxHeap
    private PriorityQueue<Integer> largeHeap; // minHeap

    public MedianFinder() {
        smallHeap = new PriorityQueue<>((a,b) -> b - a);
        largeHeap = new PriorityQueue<>();    
    }
    
    public void addNum(int num) {

        // Start by adding to smallHeap
        smallHeap.offer(num);

        // smallHeap cannot have more than 1 element than largeHeap
        // biggest number in smallHeap shouldn't be smaller than smallest number in largeHeap
        if ((smallHeap.size() - largeHeap.size() > 1) ||
            (!largeHeap.isEmpty() && smallHeap.peek() > largeHeap.peek())
        ) {
            largeHeap.offer(smallHeap.poll());
        }

        // After re-balancing above, largeHeap can have 2 more element than smallHeap.
        // Hence, need to rebalance again.
        if (largeHeap.size() - smallHeap.size() > 1) {
            smallHeap.offer(largeHeap.poll());
        }
 
    }
    
    public double findMedian() {
        if (smallHeap.size() == largeHeap.size()) {
            return (double) (smallHeap.peek() + largeHeap.peek()) / 2;
        } else if (smallHeap.size() < largeHeap.size()) {
            return (double) largeHeap.peek();
        } else {
            return (double) smallHeap.peek();
        }
    }
}
