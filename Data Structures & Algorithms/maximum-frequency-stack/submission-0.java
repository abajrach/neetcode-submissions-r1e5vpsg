class FreqStack {
    
    private List<Integer> stack;
    private Map<Integer,Integer> freq;
    
    // Brute force
    public FreqStack() {
        stack = new ArrayList<>();
        freq = new HashMap<>();
    }
    
    public void push(int val) {
        stack.add(val);
        freq.put(val, freq.getOrDefault(val, 0) + 1);
    }
    
    // 5,4,5,3,4,2,5
    /*
        5 -> 3
        3 -> 1
        4 -> 2
        2 -> 1
    */
    public int pop() {
        int maxFreq = Collections.max(freq.values());

        // Move backwards in our "stack"-list to break frequency ties
        // and mimic real stack
        for (int i = stack.size() - 1; i >= 0; i--) {
            int val = stack.get(i);
            if(freq.get(val) == maxFreq) {
                freq.put(val, freq.get(val) - 1);
                stack.remove(i);
                return val;
            }
        }
        return -1;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */