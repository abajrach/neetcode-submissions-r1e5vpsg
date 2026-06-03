class MedianFinder {

    /*
        small (maxHeap)   |  large (minHeap)
            1
    */
    PriorityQueue<Integer> smallHeap; // maxHeap
    PriorityQueue<Integer> largeHeap; // minHeap

    public MedianFinder() {
        this.smallHeap = new PriorityQueue<>((a,b) -> b - a);
        this.largeHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        smallHeap.offer(num);

        // 1 2 |  4 5 9
        if (smallHeap.size() - largeHeap.size() > 1 ||
         (!largeHeap.isEmpty() && smallHeap.peek() > largeHeap.peek())) {
            largeHeap.offer(smallHeap.poll());
        }

        // [2 1 9 3]
        //  1 2 | 3 9 
        if (largeHeap.size() - smallHeap.size() > 1) {
            smallHeap.offer(largeHeap.poll());
        }
    }
    
    public double findMedian() {
        // 2 3| 5 7
        if (smallHeap.size() == largeHeap.size()) {
            return (double) (smallHeap.peek() + largeHeap.peek()) / 2; 
        } else if (smallHeap.size() > largeHeap.size()) {
            return (double) smallHeap.peek();
        } else {
            return (double) largeHeap.peek();
        }
    }
}
