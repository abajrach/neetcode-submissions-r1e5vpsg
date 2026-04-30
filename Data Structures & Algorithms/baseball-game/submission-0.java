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
                int top = scores.pop();
                sum -= top;
            } else if (op.equals("D")) {
                int newScore = scores.peek() * 2;
                scores.push(newScore);
                sum += newScore;
            } else {
                int score = Integer.parseInt(op);
                scores.push(score);
                sum += score;
            }
        }

        return sum;
    }
}