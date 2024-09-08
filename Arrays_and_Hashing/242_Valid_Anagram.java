/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.



Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        // Returning false if lenths are equal
        if (s.length() != t.length()) return false;
        // Intialize a array to store values of alphabets
        int[] charStore = new int[26];

        for (int i = 0; i < s.length(); i++) {
            charStore[s.charAt(i) - 'a']++;
            charStore[t.charAt(i) - 'a']--;
        }

        for (int n: charStore) if (n != 0) return false;

        return true;
    }
}

// 1 ms solution
class Solution {
    public boolean isAnagram(String s, String t) {
        char[] arr = new char[26];
        for (char c: s.toCharArray()) arr[c - 'a']++;
        for (char c: t.toCharArray()) arr[c - 'a']--;
        for (int i = 0; i < 26; i++) if (arr[i] != 0) return false;
        return true;
    }
}