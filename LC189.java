/*
 * Problem:  https://leetcode.com/problems/rotate-array/
 *
 * Idea:     3 step process:
 *             1) reverse the entire array list
 *             2) reverse the first k elems
 *             3) reverse the rest n-k elems   
 *
 */

public class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        if (k < 1) return;
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }
    
    // reverse the elements in a specfied section of the array nums
    private void reverse(int[] nums, int start, int end) {
        int i = start;
        int j = end;
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
}
