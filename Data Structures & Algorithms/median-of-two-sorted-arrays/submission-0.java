class Solution {
    // Brute force
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] combined = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;

        // [1,3], 
        // [2,4]
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                combined[k++] = nums1[i++];
            } else {
                combined[k++] = nums2[j++];
            }
        }

        while (i < nums1.length) combined[k++] = nums1[i++];
        while (j < nums2.length) combined[k++] = nums2[j++];


        System.out.println(Arrays.toString(combined));
        int cLength = combined.length;

        if (cLength % 2 == 0) {
            int a = combined[cLength / 2];
            int b = combined[cLength / 2 - 1];
            return (double) (a + b) / 2.0;
            // return  (double) (combined[combined.length / 2] + combined[combined.length / 2 - 1] / 2.0);
        } else {
            return (double) combined[combined.length / 2];
        }
    }
}
