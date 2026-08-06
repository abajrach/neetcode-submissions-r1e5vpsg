class Solution {
    public int maxScore(String s) {
        int zeroes = 0, ones = 0, score = 0;

        for (char ch: s.toCharArray()) {
            if (ch == '1') ones++;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            char ch = s.charAt(i);
            if (ch == '0') {
                zeroes++;
            } else {
                ones--;
            }
            score = Math.max(score, zeroes + ones);
        }

        return score;
    }
}