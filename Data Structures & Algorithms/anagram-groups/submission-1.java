class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();

        for (String str: strs) {
            int[] count = new int[26];
            for (char ch: str.toCharArray()) {
                count[ch - 'a']++;
            }

            String key = Arrays.toString(count);
            // System.out.println(key);
            result.putIfAbsent(key, new ArrayList<>());
            result.get(key).add(str);
        }

        return new ArrayList<>(result.values());
    }
}
