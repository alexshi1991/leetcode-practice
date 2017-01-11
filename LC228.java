/*
 * Problem:  https://leetcode.com/problems/summary-ranges/
 *
 * Idea:     scan the array, find range one at a time, don't forget to add the last range
 *
 */

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0)  return result;
        int start = 0, end = start+1;
        while (end < nums.length) {
            while (nums[end] == nums[end-1] + 1) {
                end++;
                if (end == nums.length) break;
            }
            
            // found a new range
            if (start == end - 1) {
                result.add(nums[start] + "");
            } else {
                result.add(nums[start] + "->" + nums[end-1]);
            }
            
            // reset start
            start = end;
            end = start+1;
        }
        if (start == nums.length - 1) {
            result.add(nums[start] + "");
        }
        return result;
    }
}
