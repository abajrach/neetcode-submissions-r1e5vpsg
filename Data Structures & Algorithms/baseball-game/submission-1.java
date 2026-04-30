class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> scores = new Stack<>();
        int sum = 0;
        // "1","2","+","C","5","D"
        for (String op: operations) {
            if (op.equals("+")) {
                Integer tmp = scores.pop();
                Integer res = tmp + scores.peek();
                scores.push(tmp);
                scores.push(res);
                sum += res;
            } else if (op.equals("C")) {
                sum -= scores.pop();
            } else if (op.equals("D")) {
                scores.push(scores.peek() * 2);
                sum += scores.peek();
            } else {
                scores.push(Integer.parseInt(op));
                sum += scores.peek();
            }
        }

        return sum;
    }
}