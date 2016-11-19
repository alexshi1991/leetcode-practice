/*
 * Problem: https://leetcode.com/problems/combination-sum/
 *
 * Idea:   1. backtracking
 *         2. sort the candidates array first
 *         3. each recursive call only considers from candidates[level...]
 */

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        List<Integer> currList = new ArrayList<Integer>();
        Arrays.sort(candidates);
        int level = 0;
        combinationSumRecur(level, candidates, result, currList, target);
        return result;
    }
    
    private void combinationSumRecur(int level, int[] candidates, List<List<Integer>> result, List<Integer> currList, int target) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(currList));
        }
        for (int i = level; i < candidates.length; i++) {
            int num = candidates[i];
            if (num <= target) {
                currList.add(num);
                combinationSumRecur(i, candidates, result, currList, target - num);
                currList.remove(currList.size() - 1);
            } else {
                break; // since the array is sorted
            }
        }
    }
}
