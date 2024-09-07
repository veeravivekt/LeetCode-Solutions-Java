class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] arr = new int[26];
        for (int i = 0; i < sentence.length(); i++) {
            arr[sentence.charAt(i) - 'a']++;
        }

        for (int n = 0; n < 26; n++) if (arr[n]== 0) return false;
        return true;
    }
}