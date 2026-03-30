class MinStack {

    // Two stack approach. Only insert into minStack if the new 
    // value is smaller. 

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();    
    }
    
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        int tmp = stack.pop();
        if (!minStack.isEmpty() && tmp == minStack.peek()) {
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
