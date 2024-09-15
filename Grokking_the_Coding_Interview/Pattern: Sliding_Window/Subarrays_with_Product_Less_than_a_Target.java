import java.util.*;

class Solution {

    public List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int left = 0;
        int right = 0;
        int prod = 1;
        while (right < arr.length) {
            prod *= arr[right];
            while (prod >= target) prod /= arr[left++];

            List<Integer> list = new ArrayList<>();
            for (int i = right; i >= left; i--) {
                list.add(0, arr[i]);
                result.add(new ArrayList<>(list));
            }
            right++;
        }
        return result;
    }
}
