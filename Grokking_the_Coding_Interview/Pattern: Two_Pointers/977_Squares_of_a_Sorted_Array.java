class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] squaresArr = new int[nums.length];
        int pos = nums.length - 1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                squaresArr[pos] = leftSquare;
                left++;
            } else {
                squaresArr[pos] = rightSquare;
                right--;
            }
            pos--;
        }
        return squaresArr;
    }
}