/*
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.



Example 1:


Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Example 2:


Input: heights = [2,4]
Output: 4
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Pair<Integer,Integer>> stack = new Stack<>();
        int n = heights.length;
        int area = 0;
        int start;

        for (int i = 0; i < n; i++) {
            start = i;
            int curH = heights[i];
            while (!stack.isEmpty() && stack.peek().getValue() > curH) {
                Pair<Integer,Integer> p = stack.pop();
                int index = p.getKey();
                int h = p.getValue();
                area = Math.max(area, h * (i - index));
                start = index;
            }
            stack.push(new Pair(start, curH));
        }

        while (!stack.isEmpty()) {
            Pair<Integer,Integer> p = stack.pop();
            int index = p.getKey();
            int h = p.getValue();
            area = Math.max(area, h * (n - index));
        }
        return area;
    }
}