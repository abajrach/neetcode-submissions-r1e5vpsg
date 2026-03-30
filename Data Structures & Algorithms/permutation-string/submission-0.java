class Solution {
    public boolean checkInclusion(String s1, String s2) {

        // Solve again using sliding window approach
        Map<Character, Integer> s1Count = new HashMap<>();
        for (Character ch: s1.toCharArray()) {
            s1Count.put(ch, s1Count.getOrDefault(ch, 0) + 1);
        }

        int s1Size = s1Count.size();
        for (int l = 0; l < s2.length(); l++) {
            Map<Character, Integer> s2Count = new HashMap<>();
            int cur = 0;
            for (int r = l; r < s2.length(); r++) {
                char ch = s2.charAt(r);
                s2Count.put(ch, s2Count.getOrDefault(ch, 0) + 1);

                if (s1Count.getOrDefault(ch, 0) < s2Count.get(ch)) {
                    break;
                }

                if (s1Count.getOrDefault(ch, 0) == s2Count.get(ch)) {
                    cur++;
                }

                if (cur == s1Size) {
                    return true;
                }
            }
        }

        return false;
    }
}
