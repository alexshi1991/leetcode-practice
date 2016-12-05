/*
 * Problem:  https://leetcode.com/problems/subsets-ii/
 *
 * Idea:     1. recursion, backtracking
 *           2. sort the input array first
 *           3. for each recursive call, consider:
 *              a) including nums[index] in result
 *              b) excluding nums[index] in result
 *              c) if choose to exclude, also skip all the duplicates
 */

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null) return result;
        List<Integer> currList = new ArrayList<Integer>();
        findSubsets(nums, result, currList, 0);
        return result;
    }
    
    private void findSubsets(int[] nums, List<List<Integer>> result, List<Integer> currList, int index) {
        if (index == nums.length) {
            result.add(new ArrayList<Integer>(currList));
        } else {
            // include element at nums[index] in the currList
            currList.add(nums[index]);
            findSubsets(nums, result, currList, index+1); 
            // exclude element at nums[index] in the currList, also skip all the elements that equals nums[index]
            currList.remove(currList.size() - 1); // backtracking
            int j = index + 1;
            while (j < nums.length && nums[j] == nums[index]) {
                j++;
            }
            findSubsets(nums, result, currList, j); 
        }
    }
}
