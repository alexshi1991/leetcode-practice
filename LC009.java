/*
 * Problem: https://leetcode.com/problems/palindrome-number/
 *
 * Idea: compare to see if the right half of input is a mirror of the left half
 */


public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {return false;} // negative integer can never be palindrome
        if (x == 0) {return true;} 
        if (x % 10 == 0) {return false;}  // integers like 20, 300, 131000... are not palindromes 
        int mirror = 0; // right half of x
        while (x > mirror) {
            mirror = mirror * 10 + x % 10;
            x /= 10;
        }
        return (mirror == x) || (x == mirror / 10);
    }
}