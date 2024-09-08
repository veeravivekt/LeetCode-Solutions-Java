class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;
        int l = 2;
        int r = x / 2;
        while (l <= r) {
            int m = l + (r - l) / 2;
            long num = (long) m * m;

            if (num > x) {
                r = m - 1;
            } else if (num < x) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return r;
    }
}