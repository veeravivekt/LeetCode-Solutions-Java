class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int s: stones) pq.add(s);
        while (pq.size() > 1) {
            int smash = pq.poll() - pq.poll();
            if (smash == 0) continue;
            pq.add(smash);
        }
        return pq.size() > 0 ? pq.poll() : 0;
    }
}