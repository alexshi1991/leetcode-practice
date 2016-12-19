/*
 * Problem:  https://leetcode.com/problems/single-number-ii/
 *
 * Idea:     1. think about all the int numbers as 32 bits
 *           2. count the number of 1s at each bit across all numbers,
 *              sum %= 3 will clear it once it reaches 3
 *           3. after running for all the numbers for each bit, 
 *              if we have a 1, then that 1 belongs to the single number
 *           4. time complexity O(32n) ~= O(n), this is a very generalized approach
 */


public class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i = 0; i < 32; i++) {
            int sum = 0;
            for(int j = 0; j < nums.length; j++) {
                if(((nums[j] >> i) & 1) == 1) {
                    sum++;
                    sum %= 3;
                }
            }
            if(sum != 0) {
                ans |= sum << i;
            }
        }
        return ans;
    }
}
