/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.



Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Initialize Data Structures
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length + 1];

        // Count Frequencies
        for (int i: nums) map.put(i, map.getOrDefault(i, 0) + 1);

        // Bucketing
        for (int key: map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        // Fetch the top K elements from bucket
        int[] topK = new int[k];
        int pos = 0;
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                for (int j = 0; j < bucket[i].size() && pos < k; j++) {
                    topK[pos] = bucket[i].get(j);
                    pos++;
                }
            }
        }
        return topK;
    }
}