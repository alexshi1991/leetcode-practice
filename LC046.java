/*
 * Problem: https://leetcode.com/problems/permutations/
 *
 * Idea:   1. backtracking
 *         2. use a boolean array to track which elements have been used in the current permutation
 */

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        if (nums == null) return permutations;
        boolean[] used = new boolean[nums.length];
        recPermute(nums, used, new ArrayList<Integer>(), permutations);
        return permutations;
    }
    
    private void recPermute(int[] nums, boolean[] used, ArrayList<Integer> permutation, List<List<Integer>> permutations) {
        if (permutation.size() == nums.length) {
            permutations.add(new ArrayList<Integer>(permutation)); //Important: make a copy
        } else {
            for (int i = 0; i < used.length; i++) {
                if (!used[i]) {
                    permutation.add(nums[i]);
                    used[i] = true;
                    recPermute(nums, used, permutation, permutations);
                    used[i] = false;
                    permutation.remove(permutation.size() - 1);
                }
            }
        }
    }
}
