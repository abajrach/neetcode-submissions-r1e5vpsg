class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int l = 0, r = people.length - 1;

        int boats = 0;
        while (l <= r) {
            boats++; // Each people is at or below limit. So, need at least one boat.
            int remaining = limit - people[r];

            if (people[l] <= remaining) {
                l++;
            }
            r--;
        }
        return boats;
    }
}