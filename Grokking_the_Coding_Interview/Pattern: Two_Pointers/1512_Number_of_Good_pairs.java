class Solution {
    public int numIdenticalPairs(int[] nums) {
        int pairCount = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int n1 = nums[i];
            for(int j = i + 1; j < nums.length; j++) if (n1 == nums[j]) pairCount++;
        }
        return pairCount;
    }
}

// HashMap Solution
class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int pairCount = 0;
        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
            pairCount += map.get(n) - 1;
        }
        return pairCount;
    }
}