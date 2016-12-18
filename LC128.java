/*
 * Problem:  https://leetcode.com/problems/longest-consecutive-sequence/
 *
 * Idea:     1. construct a hashset, put elem in nums into this set
 *           2. for every element in array, we find the largest consecutive sequence
 *              containing this element, and remove elements from the hashset
 *
 */



public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int n: nums) {
            set.add(n);
        }
        int currLength = 1, maxLength = 1;
        for (int n: nums) {
            currLength = 1;
            int smaller = n - 1;
            int larger = n + 1;
            set.remove(n);
            while (set.contains(larger)) {
                currLength++;
                set.remove(larger);
                larger++;
            }
            while (set.contains(smaller)) {
                currLength++;
                set.remove(smaller);
                smaller--;
            }
            maxLength = Math.max(currLength, maxLength);
        }
        return maxLength;
    }
}
