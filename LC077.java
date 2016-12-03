/*
 * Problem: https://leetcode.com/problems/combinations/
 *
 * Idea:    backtracking
 */


public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k < 1 || n < 1) return result;
        findCombination(new ArrayList<Integer>(), result, n, k, 1);
        return result;
    }
    
    private void findCombination(List<Integer> curr, List<List<Integer>> result, int n, int k, int start) {
        if (curr.size() == k) {
            result.add(new ArrayList<Integer>(curr));
            return;
        }
        for (int i = start; i <= n; i++) {
            curr.add(i);
            findCombination(curr, result, n, k, i+1);
            curr.remove(curr.size() - 1); // backtracking
        }
    }
}
