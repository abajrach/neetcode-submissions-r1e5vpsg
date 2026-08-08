class MinStack {
    private Stack<Pair<Integer, Integer>> stack;

    public MinStack() {
        this.stack = new Stack<>();
    }
    
    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new Pair(val, val));
        } else {
            int curMin = stack.peek().getValue();
            int newMin = curMin < val ? curMin : val;
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
