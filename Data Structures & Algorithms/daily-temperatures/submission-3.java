class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Holds [value, index]
        Stack<int[]> stack = new Stack<>();

        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > stack.peek()[0]) {
                int[] top = stack.pop();
                res[top[1]] = i - top[1];
            }
            stack.push(new int[] {temperatures[i], i});
        }

        return res;
    }
}
