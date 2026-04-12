class Solution {
    // Sorting. O(n * mlogm)
    // ["act","pots","tops","cat","stop","hat"]
    /*
        sort(cat) -> act


    */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for (String s: strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedS = new String(chars);

            result.putIfAbsent(sortedS, new ArrayList<>());
            result.get(sortedS).add(s);
        }

        return new ArrayList<>(result.values());
    }
}
