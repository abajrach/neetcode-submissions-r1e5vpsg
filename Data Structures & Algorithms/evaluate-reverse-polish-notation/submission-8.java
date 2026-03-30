class Solution {
    public int evalRPN(String[] tokens) {
        List<String> tokenList = new ArrayList<>(Arrays.asList(tokens));

        return compute(tokenList);
    }

    private int compute(List<String> tokens) {
        String token = tokens.remove(tokens.size() - 1);

        if(!"+-*/".contains(token)) { // if its a number
            return Integer.parseInt(token);
        }

        int right = compute(tokens);
        int left = compute(tokens);


        if (token.equals("+")) {
            return left + right;
        } else if (token.equals("-")) {
            return left - right;
        } else if (token.equals("*")) {
            return left * right;
        } else {
            return left / right;
        }

    }
}
