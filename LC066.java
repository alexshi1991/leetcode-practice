/*
 * Problem: https://leetcode.com/problems/plus-one/
 *
 * Idea:    1. compute individual digits and save results to a stack
 *          2. start from LSB
 *          3. allocate new array to store the result of plusOne
 *          4. new array size depends on whether there is a carryover for the MSB
 */



public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1; // this is the plus one
        int digit = 0;
        Stack<Integer> stack = new Stack<>();
        // start from the least significant digit
        for (int i = digits.length - 1; i >= 0; i--) {
            digit = (digits[i] + carry) % 10;
            carry = (digits[i] + carry) / 10;
            stack.push(digit);
        }
        
        int[] newDigits = null;
        int i = 0; // starting index
        if (carry == 0) {
            newDigits = new int[digits.length];
        } else {
            newDigits = new int[digits.length+1];
            newDigits[0] = 1;
            i++;
        }
        while (!stack.isEmpty()) {
            newDigits[i++] = stack.pop();
        }
        return newDigits;
    }
}
