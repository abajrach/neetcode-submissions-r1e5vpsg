class FreqStack {
    
    // private List<Integer> stack;
    private PriorityQueue<int[]> maxHeap; // Orders by frequency
    private Map<Integer,Integer> freq;
    private int index;

    // Brute force
    public FreqStack() {
        // Sort by frequency. If tie, sort by index descending.
        // Stores [frequency, index, value]
        maxHeap = new PriorityQueue<>((a,b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);
        freq = new HashMap<>();
    }
    
    public void push(int val) {
        maxHeap.offer(new int[]{ freq.getOrDefault(val, 0), index, val });
        freq.put(val, freq.getOrDefault(val, 0) + 1);
        index++;
    }
    
    // 5,4,5,3,4,2,5
    /*
        5 -> 3
        3 -> 1
        4 -> 2
        2 -> 1
    */
    public int pop() {
        int[] item = maxHeap.poll();
        int val = item[2];
        freq.put(val, freq.get(val) - 1);
        index--;
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */