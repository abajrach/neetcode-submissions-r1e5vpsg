class FreqStack {
    
    private Map<Integer,Integer> freq;
    private Map<Integer, Stack<Integer>> stacks;
    private int maxCnt;

    // Using Map of stacks. O(1) time and O(n) space
    public FreqStack() {
        freq = new HashMap<>();
        stacks = new HashMap<>();
    }
    
    public void push(int val) {
        int count = freq.getOrDefault(val, 0) + 1;
        freq.put(val, count);
        if (count > maxCnt) {
            maxCnt = count;
            stacks.putIfAbsent(count, new Stack<>());
        }
        stacks.get(count).push(val);
    }
    
    // 5,4,5,3,4,2,5
    /*
        5 -> 3
        3 -> 1
        4 -> 2
        2 -> 1
    */
    public int pop() {
        int val = stacks.get(maxCnt).pop();
        freq.put(val, freq.get(val) - 1);
        if (stacks.get(maxCnt).isEmpty()) {
            maxCnt--;
        }
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */