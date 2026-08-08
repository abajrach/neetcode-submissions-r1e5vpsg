class MinStack {

    // Each node is (value, currentMinSoFar)
    private Stack<Pair<Integer, Integer>> stack;

    public MinStack() {
        this.stack = new Stack<>();
    }
    
    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new Pair(val, val));
        } else {
            int newMin = Math.min(val, stack.peek().getValue());
            stack.push(new Pair(val, newMin));
        }
    }
    
    public void pop() {
        stack.pop();        
    }
    
    public int top() {
        return stack.peek().getKey();
    }
    
    public int getMin() {
        return stack.peek().getValue();
    }
}
