class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return false;

        Stack<Character> stack = new Stack<>();
        for (Character c: s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else {
                // Need to handle edge case where s = ']'
                if (stack.isEmpty() || stack.pop() != c) return false;
            }
        }

        return stack.isEmpty();
    }
}
