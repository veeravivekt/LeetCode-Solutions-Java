/*
Given a string s, find the length of the longest
substring
 without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxStr = 0;
        List<Character> subStr = new ArrayList<>();
        for (int right = 0; right < s.length(); right++) {
            if (subStr.contains(s.charAt(right))) {
                int index = subStr.indexOf(s.charAt(right));
                subStr.remove(index);
                if (index > 0) subStr.subList(0,index).clear();
            }
            subStr.add(s.charAt(right));
            maxStr = Math.max(maxStr, subStr.size());
        }
        return maxStr;
    }
}