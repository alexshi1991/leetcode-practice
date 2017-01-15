/*
 * Problem:  https://leetcode.com/problems/ugly-number/
 *
 * Idea:     1. continuously divide by 2, 3, 5 until a different prime factor occurs
 *           2. if number is ugly, num will eventually become 1
 *
 */

public class Solution {
    public boolean isUgly(int num) {
        if (num <= 0) return false; // only positive nums can be ugly
        while (num > 1) {
            if (num % 5 == 0) num /= 5;
            else if (num % 3 == 0) num /= 3;
            else if (num % 2 == 0) num /= 2;
            else return false;  // num includes another prime
        }
        return true;
    }
}
