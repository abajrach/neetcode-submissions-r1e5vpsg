class Solution {
        
    private String[] digitToChar = { "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) return result;

        backtrack(0, "", digits, result);
        return result;
    }

    private void backtrack(int i, String curStr, String digits, List<String> result) {
        if (curStr.length() == digits.length()) {
            result.add(curStr);
            return;
        }

        String letters = digitToChar[digits.charAt(i) - '0']; // For 3, returns "def"
        for (char ch: letters.toCharArray()) {
            backtrack(i + 1, curStr + ch, digits, result);
        }
    }
}
