/*
 * Problem: https://leetcode.com/problems/contains-duplicate-ii/
 *
 * Idea:    hashtable, that tracks the number (key) and last occurance of this number (val)
 *
 */

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1 ) return false;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (map.containsKey(n)) {
                int j = map.get(n); // location j is the last occurrance of n
                if (i - j <= k) {
                    return true;
                }
            }
            map.put(n, i);  // update last occurrance index
        }
        
        return false;        
    }
}
