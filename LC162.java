/*
 * Problem:  https://leetcode.com/problems/find-peak-element/
 * 
 * Idea:     1. binary search find the result in logrithmic time
 *           2. repeated cut the prob size in half and check whether 
 *              nums[mid] is the peak element
 *           3. if while-loop exists without finding a peak,
 *              then the peak is at either nums[0] or nums[n-1],
 *              because we have negative infinity at nums[-1] and nums[n]
 *
 */

public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        
        // binary search
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid - 1] 
                && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] < nums[mid - 1]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        // if still has not found a peak, then
        // either start = 0, end = 1
        // or     start = n-2, end = n-1,
        // because nums[-1] = nums[n] = negative infinity,
        // we can also find a peak
        return nums[start] > nums[end] ? start : end;        
    }
}
