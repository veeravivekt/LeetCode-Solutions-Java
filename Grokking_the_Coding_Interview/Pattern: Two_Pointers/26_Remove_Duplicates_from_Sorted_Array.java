class Solution {
    public int removeDuplicates(int[] nums) {
        int nonDuplicate = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[nonDuplicate - 1] != nums[i]) {
                nums[nonDuplicate] = nums[i];
                nonDuplicate++;
            }
        }
        return nonDuplicate;
    }
}