class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // 30,38,30,36,35,40,28
        // Stack -> 
        // (30, 0), (38, 1), (30, 2), (36, 3)
        // [ (1-0), (), (3 - 2)]

        int[] result = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            int t = temperatures[i];
            while (!stack.isEmpty() && t > stack.peek()[0]) {
                int[] top = stack.pop();
                result[top[1]] = i - top[1];
            }
            stack.push(new int[] {t, i});
        }
        return result;
    }
}
