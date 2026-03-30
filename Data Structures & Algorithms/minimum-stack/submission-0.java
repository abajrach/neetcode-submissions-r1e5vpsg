class MinStack {

    Stack<Integer> _stack;
    Stack<Integer> _minStack;

    public MinStack() {
        _stack = new Stack<>();    
        _minStack = new Stack<>();
    }
    
    public void push(int val) {
        _stack.push(val);

        if(!_minStack.isEmpty() && val > _minStack.peek()) {
            int oldMinVal = _minStack.pop();
            _minStack.push(val);
            _minStack.push(oldMinVal);
        } else {
            _minStack.push(val);
        }
    }
    
    public void pop() {
        int poppedVal = _stack.pop();
        if (!_minStack.isEmpty() && _minStack.peek() != poppedVal) {
            int tmp = _minStack.pop();
            _minStack.pop();
            _minStack.push(tmp);
        } else {
            _minStack.pop();
        }
    }
    
    public int top() {
        return _stack.peek();
    }
    
    public int getMin() {
        return _minStack.peek();
    }
}
