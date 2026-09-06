class Solution {
    public int lengthOfLastWord(String s) {
        String[] tokens = s.split(" ");
        // System.out.println(Arrays.toString(tokens));

        return tokens[tokens.length - 1].length();
    }
}