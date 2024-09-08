class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int shortest = words.length;
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) index1 = i;
            if (word2.equals(words[i])) index2 = i;
            if (index1 != -1 && index2 != -1) {
                shortest = Math.min(shortest, Math.abs(index1 - index2));
            }
        }
        return shortest;
    }
}
