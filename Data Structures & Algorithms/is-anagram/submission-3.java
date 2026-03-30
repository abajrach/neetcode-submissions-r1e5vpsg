class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> countMap = new HashMap<>();

        for (char ch: s.toCharArray()) {
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }

        for (char ch: t.toCharArray()) {
            countMap.put(ch, countMap.getOrDefault(ch, 0) - 1);
        }

        for (char ch: countMap.keySet()) {
            if (countMap.get(ch) != 0) {
                return false;
            }
        }

        return true;
    }
}
