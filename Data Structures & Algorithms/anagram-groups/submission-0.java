class Solution {
    /*
        Sorting strings.
    */
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> result = new HashMap<>();

        for (String s: strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            result.putIfAbsent(sortedStr, new ArrayList<>());
            result.get(sortedStr).add(s);
        }

        return new ArrayList<>(result.values());
    }
}
