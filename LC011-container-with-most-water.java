/*
 * Problem:  https://leetcode.com/problems/container-with-most-water/
 * 
 * Idea: 1. use two pointers to gradually decrease the width of the area
 *       2. always move the shorter line inwards in hope of searching for a line with greater height
 *       3. skipping those lines that are shorter than the current short line
 *       4. single pass, O(n) time complexity compared to brute-force O(n*n)
 */


public class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = Integer.MIN_VALUE;
        while (left < right) {
            int shorter = Math.min(height[right], height[left]);
            max = Math.max(max, (right - left) * shorter);
            while (height[left] <= shorter && left < right) {
                left++;
            }
            while (height[right] <= shorter && left < right) {
                right--;
            }
        }
        return max;
    }
}
