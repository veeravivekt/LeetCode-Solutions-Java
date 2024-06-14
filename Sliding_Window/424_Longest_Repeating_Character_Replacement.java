/*
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.



Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.

 */

class Solution {
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int ans = 0;
        int maxCount = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            arr[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, arr[s.charAt(right) - 'A']);
            // slidingwindow(right - left) - maxCount of Alpha in that window
            // should not exceed k
            if ((right - left + 1) - maxCount > k) {
                arr[s.charAt(left) - 'A']--;
                left++;
            }
            ans = Math.max(ans, (right - left + 1));
        }
        return ans;
    }
}