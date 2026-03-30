class Solution {

    // Brute force. O(n^2)
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int j = i + 1;
            int count = 1;
            while(j < n) {
                if (temperatures[j] > temperatures[i]) {
                    break;
                }

                count++;
                j++;
            }

            res[i] = j == n ? 0 : count;
        }

        return res;
    }
}
