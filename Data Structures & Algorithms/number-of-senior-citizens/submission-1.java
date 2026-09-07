class Solution {
    public int countSeniors(String[] details) {
        // 7868190130 M 75 22
        // 
        int count = 0;
        for (String detail: details) {
            // int age = Integer.valueOf(detail.substring(11, 13));
            // String ageStr = detail.substring(11,13);
            int ten = detail.charAt(11) - '0';
            int one = detail.charAt(12) - '0';

            int age = ten * 10 + one;
            
            if (age > 60) {
                count++;
            }
        }
        return count;
    }
}