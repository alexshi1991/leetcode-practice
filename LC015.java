/*
 * Problem: https://leetcode.com/problems/3sum/
 *
 * Idea: 1. sort the input array first
 *       2. use each item in the array as the first item in a potential triplet match
 *       3. use two pointers, left points to i+1, right points to array.length-1, perform bi-directional scan
 *       4. total time complexity is O(N*N)
 */


public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        if (nums == null || nums.length == 0) { return result; }
        
        Arrays.sort(nums);
        
        int prevTarget = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int target = 0 - nums[i]; // a + b + c = 0 -> b + c = -a
            if (i >= 1 && prevTarget == target) {
                continue; // skip duplicates
            }
            int left = i+1, right = nums.length-1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // move left and right pointers, skip duplicates
                    while (left + 1 < nums.length && nums[left] == nums[left+1]) {
                        left++;
                    }
                    left++;
                    while (right-1 >= 0 && nums[right] == nums[right-1]) {
                        right--;
                    }
                    right--;
                }
            }
            prevTarget = target;
        }
        
        return result;
    }
}