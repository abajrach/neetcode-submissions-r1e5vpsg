class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int l = 0, r = people.length - 1;
        int boats = 0;
        while (l <= r) {
            int remaining = limit - people[r];
            boats++;

            if(people[l] <= remaining) {
                l++;
            }
            r--;
        }
        return boats;
    }
}