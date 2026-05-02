class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();

        // 34[bc]
        //          -> 
        // 3,4
        // subStr = bc
        // k = "34"
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ']') {
                stack.push(String.valueOf(s.charAt(i)));
            } else {
                StringBuilder subStr = new StringBuilder();
                while(!stack.isEmpty() && !stack.peek().equals("[")) {
                    subStr.insert(0, stack.pop());
                }
                stack.pop();

                StringBuilder k = new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    k.insert(0, stack.pop());
                }

                int count = Integer.parseInt(k.toString());
                String repeatedStr = subStr.toString().repeat(count);
                stack.push(repeatedStr);
            }
        }

        // stack: abab c
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }
        return res.toString();
    }
}