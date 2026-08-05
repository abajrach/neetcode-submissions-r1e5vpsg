class Solution {
    public int maxScore(String s) {
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            int leftZeroes = 0, rightOnes = 0;
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == '0') {
                    leftZeroes++;
                }
            }

            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == '1') {
                    rightOnes++;
                }
            }

            res = Math.max(res, leftZeroes + rightOnes);
        }

        return res;
    }
}