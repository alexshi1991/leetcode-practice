/*
 * Problem:  https://leetcode.com/problems/combination-sum-iii/
 *
 * Idea:     dfs + backtracking
 *
 */


public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (k <= 0 || n <= 0) return result;
        List<Integer> currList = new ArrayList<Integer>();
        findCombination(result, currList, 0, k, n);
        return result;
    }
    
    // recursive method used to find any qualifying combination
    private void findCombination(List<List<Integer>> result, List<Integer> currList, int currSum, int k, int n) {
        int num = currList.isEmpty() ? 0 : currList.get(currList.size() - 1);
        // base case
        if (currSum == n && currList.size() == k) {
            result.add(new ArrayList<Integer>(currList));
            return;
        }
        if (currList.size() == k) { return; }
        
        // recursion
        for (int i = num + 1; i <= 9; i++) {
            currSum += i;
            if (currSum > n) { break; }
            currList.add(i);
            findCombination(result, currList, currSum, k, n);
            currSum -= i;
            currList.remove(currList.size() - 1);
        }
    }
}
