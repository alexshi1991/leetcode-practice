/*
 * Problem: https://leetcode.com/problems/permutations-ii/
 *
 * Idea:    1. backtracking, recursion
 *          2. use a boolean array to keep track of which items have been used
 *          3. sort the arrays first so that duplicates are adjacent
 *          4. when a number has the same value with its previous,
 *             we can only use this number if his previous is marked as used, 
 *             otherwise this number and its previous are being considered at the same level,
 *             we need to skip adding this number because it will cause duplicates in end result
 */


public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        boolean[] used = new boolean[nums.length];
        List<Integer> currPermute = new ArrayList<>();
        Arrays.sort(nums);
        recPermuteUnique(nums, used, currPermute, res);
        return res;
    }
    
    private void recPermuteUnique(int[] nums, boolean[] used, List<Integer> currPermute, List<List<Integer>> res) {
        if (currPermute.size() == nums.length) {
            res.add(new ArrayList<Integer>(currPermute));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // item already used in curr permutation
            if (used[i]) continue; 
            // when a number has the same value with its previous,
            // we can use this number only if his previous is used,
            if (i > 0 && nums[i-1] == nums[i] && !used[i-1]) continue;
            used[i] = true;
            currPermute.add(nums[i]);
            recPermuteUnique(nums, used, currPermute, res);
            used[i] = false;
            currPermute.remove(currPermute.size()-1);
        }
    }
}
