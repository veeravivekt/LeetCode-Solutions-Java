class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int n: nums) add(n); // why does this work you ask? coz the return value for calling this is doing nothing. The other calls are calling add function directly
    }

    public int add(int val) {
        if (pq.size() < k) pq.add(val);
        else if (val > pq.peek()) {
            pq.poll();
            pq.add(val);
        }
        return pq.peek();
    }
}

