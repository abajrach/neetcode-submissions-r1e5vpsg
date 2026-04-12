class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> count = new HashMap<>();

        for (char ch: s.toCharArray()) {
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }

        for (char ch: t.toCharArray()) {
            if (!count.containsKey(ch)) {
                return false;
            }
            
            count.put(ch, count.get(ch) - 1);

            if (count.get(ch) <= 0) {
                count.remove(ch);
            }
        }

        return count.size() == 0;
    }
}
