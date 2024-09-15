import java.util.*;

class Solution {

    public int searchTriplets(int[] arr, int target) {
        int count = 0;
        if (arr.length < 3) return 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;
            while (left < right) {
                if (arr[i] + arr[left] + arr[right] < target) {
                    count += right - left;
                    left++;
                } else right--;
            }
        }
        return count;
    }
}
