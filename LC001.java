/* 
 * Problem: https://leetcode.com/problems/two-sum/
 
 * Idea: use hashtable to store <number, idx> pairs, 
 *       for each item we check if its compliment is in the hashmap, 
 *       if yes, we found the solution, return the indices array,
 *       if not, we add current item to the hashmap and move on to the next item.
 */

public class LC001 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}