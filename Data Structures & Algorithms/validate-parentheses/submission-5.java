class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (Character ch: s.toCharArray()) {
            if (ch == '(') stack.push(')');
            else if (ch == '{') stack.push('}');
            else if (ch == '[') stack.push(']');
            else {
                // Character item = stack.pop();
                // if (item != ch) return false;
                if (stack.isEmpty() || ch != stack.pop()) return false;
            }
        }

        return stack.isEmpty();
    }
}
