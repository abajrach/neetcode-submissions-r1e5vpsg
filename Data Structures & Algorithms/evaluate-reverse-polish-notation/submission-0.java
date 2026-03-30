class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s: tokens) {
            if (s.equals("+")) {
                // int tmpResut = 0;
                // while (!stack.isEmpty()) {
                //     tmpResult += Integer.parseInt(stack.pop());
                // }
                stack.push(stack.pop() + stack.pop());
            } else if (s.equals("-")) {
                // int tmpResult = -1;
                // while (!stack.isEmpty()) {
                    // tmpResult -= 
                // }
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if (s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (s.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }

        return stack.pop();
    }
}
