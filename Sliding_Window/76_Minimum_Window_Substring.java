/*
Given two strings s and t of lengths m and n respectively, return the minimum window
substring
 of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.



Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.



 */
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c: t.toCharArray()) map.put(c, map.getOrDefault(c,0) + 1);

        int matched = 0;
        int subStr = 0;
        int minLen = s.length() + 1;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) matched++;
            }

            while (matched == map.size()) {
                if (minLen > right - left + 1) {
                    minLen = right - left + 1;
                    subStr = left;
                }

                char popped = s.charAt(left++);
                if (map.containsKey(popped)) {
                    if (map.get(popped) == 0) matched--;
                    map.put(popped, map.get(popped) + 1);
                }
            }
        }
        return minLen > s.length()? "" : s.substring(subStr, subStr + minLen);
    }
}