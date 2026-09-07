class Solution {
    public int countSeniors(String[] details) {
        // 7868190130 M 75 22
        // 
        int count = 0;
        for (String detail: details) {
            int age = Integer.valueOf(detail.substring(11, 13));
            if (age > 60) {
                count++;
            }
        }
        return count;
    }
}