/*
 * Problem: https://leetcode.com/problems/subsets/
 *
 * Idea:    1. backtracking
 *          2. an index is passed to the recursive function
 *          3. two recursive calls:
 *             a) consider including element at nums[index] in currList
 *             b) consider excluding element at nums[index] in currList
 *          4. no-duplicate requirement is guaranteed since the array elements are distinct
 */


public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) return result;
        findSubsets(nums, result, new ArrayList<Integer>(), 0);
        return result;
    }
    
    private void findSubsets(int[] nums, List<List<Integer>> result, List<Integer> currList, int index) {
        if (index == nums.length) {
            result.add(new ArrayList<Integer>(currList));
        } else {
            currList.add(nums[index]);
            findSubsets(nums, result, currList, index+1); // include element at nums[index] in the currList
            currList.remove(currList.size()-1);
            findSubsets(nums, result, currList, index+1); // exclude element at nums[index] in the currList
        }
    }
}
