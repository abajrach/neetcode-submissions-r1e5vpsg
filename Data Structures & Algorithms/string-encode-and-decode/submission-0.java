class Solution {

    // Build result = "5#Hello5#World"
    public String encode(List<String> strs) {
        StringBuilder encodedStr = new StringBuilder();

        for (String s: strs) {
            encodedStr.append(s.length());
            encodedStr.append("#");
            encodedStr.append(s);
        }

        return encodedStr.toString();
    }

    // str = "5#Hello5#World"
    public List<String> decode(String str) {
        List<String> result = new ArrayList();

        int i = 0;

        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }

            int length = Integer.parseInt(str.substring(i,j));
            i = j + 1;
            j = i + length;
            result.add(str.substring(i, j));
            i = j;            
        }

        return result;
    }
}
