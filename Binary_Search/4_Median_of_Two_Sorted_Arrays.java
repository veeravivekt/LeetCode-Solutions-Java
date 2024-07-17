/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).



Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        if (len1 > len2) return findMedianSortedArrays(nums2, nums1);

        int total = len1 + len2;
        int half = (total + 1) / 2;

        int left = 0;
        int right = len1;

        var result = 0.0;

        while (left <= right) {
            int m1 = left + (right - left) / 2;
            int m2 = half - m1;

            int l1 = (m1 > 0) ? nums1[m1 - 1] : Integer.MIN_VALUE;
            int r1 = (m1 < len1) ? nums1[m1] : Integer.MAX_VALUE;
            int l2 = (m2 > 0) ? nums2[m2 - 1] : Integer.MIN_VALUE;
            int r2 = (m2 < len2) ? nums2[m2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                if (total % 2 == 0) {
                    result = (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    result = Math.max(l1, l2);
                }
                break;
            } else if (l1 > r2) {
                right = m1 - 1;
            } else {
                left = m1 + 1;
            }
        }
        return result;
    }
}