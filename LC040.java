/*
 * Problem: https://leetcode.com/problems/combination-sum-ii/
 *
 * Idea:    1. backtracking
 *          2. sort the candidates first
 *          3. each number in candidates array may only be used once (different from combinationSum)
 *          4. IMPORTANT: problem assumes the candidates array MAY contain duplicates 
 *          5. skip duplicates within each level
 */

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        List<Integer> currList = new ArrayList<Integer>();
        Arrays.sort(candidates);
        int level = 0;
        combinationSum2Recur(level, candidates, result, currList, target);
        return result;
    }
    
    private void combinationSum2Recur(int level, int[] candidates, List<List<Integer>> result, List<Integer> currList, int target) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(currList));
        }
        for (int i = level; i < candidates.length; i++) {
            int num = candidates[i];
            if (i > level && candidates[i] == candidates[i - 1]) {
                continue; // same number can only be used once on the same level, avoid duplicates
            }    
            if (num <= target) {
                currList.add(num);
                combinationSum2Recur(i + 1, candidates, result, currList, target - num);
                currList.remove(currList.size() - 1);
            } else {
                break; // since the array is sorted
            }
        }
    }
}
