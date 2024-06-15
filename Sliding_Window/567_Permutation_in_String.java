/*
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.



Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false

 */
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int[] arr1 = new int[26];
        for (int i = 0; i < n; i++) {
            arr1[s1.charAt(i) - 'a']++;
        }

        int[] arr2 = new int[26];
        for (int i = 0; i < s2.length(); i++) {
            arr2[s2.charAt(i) - 'a']++;

            if (i >= n) {
                arr2[s2.charAt(i - n) - 'a']--;
            }

            if (Arrays.equals(arr1,arr2)) return true;
        }
        return false;
    }
}