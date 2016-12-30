/*
 * Problem:  https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * Idea:     1. two pointers
 *           2. left pointer starts at 0, right pointer starts at length-1
 *           3. move left pointer to the right and right pointer to the left until 
 *              numbers[left] + numbers[right] == target
 */

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int left = 0, right = numbers.length - 1;
        while ((numbers[left] + numbers[right] != target) && (left < right)) {
            int curr = numbers[left] + numbers[right];
            if (curr < target) left++;
            else right--;
        }
        result[0] = left+1;
        result[1] = right+1;
        return result;        
    }
}
