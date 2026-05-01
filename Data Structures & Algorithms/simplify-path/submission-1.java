class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        /*
            /abc/../ -> /

            /a/b 
        */
        for (char ch: (path + "/").toCharArray()) {
            if (ch == '/') {
                if (sb.toString().equals("..")) {
                    if (!stack.isEmpty()) stack.pop();
                } else if (!sb.toString().equals("") && !sb.toString().equals(".")) {
                    stack.push(sb.toString());
                }
                sb.setLength(0);
            } else {
                sb.append(ch);
            }
        }

        return "/" + String.join("/", stack);
    }
}