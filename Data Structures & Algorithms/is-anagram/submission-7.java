class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> count = new HashMap<>();

        for (char ch: s.toCharArray()) {
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }

        for (char ch: t.toCharArray()) {
            count.put(ch, count.getOrDefault(ch, 0) - 1);
        }

        for (char ch: count.keySet()) {
            if (count.get(ch) != 0) {
                return false;
            }
        }

        return true;
    }
}
