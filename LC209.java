/*
 * Problem:  https://leetcode.com/problems/minimum-size-subarray-sum/
 *
 * Idea:     two pointers, sliding window
 *
 */


public class Solution {
    // sliding window, two pointers
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0, right = 0, currSum = 0;
        int minLen = Integer.MAX_VALUE;
        
        while (right < nums.length) {
            currSum += nums[right];
            if (currSum >= s) {
                // move left ptr
                while (left <= right) {
                    if ((currSum - nums[left]) >= s) {
                        currSum -= nums[left];
                        left++;
                    } else {
                        break;
                    }
                }
                // compare minLength
                int currLen = right - left + 1;
                minLen = Math.min(minLen, currLen);
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
