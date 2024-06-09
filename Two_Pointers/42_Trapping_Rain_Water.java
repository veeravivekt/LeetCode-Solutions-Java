/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.



Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 */
class Solution {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int ans = 0;

        // Get Max of left side
        int max = height[0];
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(height[i],max);
            max = left[i];
        }

        // Get Max of Right Side
        max = height[height.length - 1];
        for (int i = height.length - 1; i >= 0; i--) {
            right[i] = Math.max(height[i],max);
            max = right[i];
        }

        // Get Min of left and right then caliculate space
        for (int i = 0; i < height.length; i++) {
            ans += Math.max(Math.min(left[i], right[i]) - height[i], 0);
        }
        return ans;
    }
}