/*
 * Problem: https://leetcode.com/problems/trapping-rain-water/
 *
 * Idea:    1. scan array left -> right, use auxiliary array to store max heights from left
 *          2. scan array right -> left, use auxiliary array to store max heights from right
 *          3. for each bar i, Math.min(maxLeft[i], maxRight[i]) - height[i] is the volume of water it can trap above its height
 */


public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int max = 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            max = Math.max(height[i], max);
            maxLeft[i] = max;
        }
        max = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            max = Math.max(height[i], max);
            maxRight[i] = max;
        }
        
        int volume = 0;
        for (int i = 0; i < height.length; i++) {
            volume += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        return volume;
    }
}
