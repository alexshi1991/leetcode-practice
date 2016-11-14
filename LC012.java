/*
 * Problem: https://leetcode.com/problems/integer-to-roman/
 *
 * Idea: 1. Understand the mapping between roman numerals to integers (1, 2, 3...), (10, 20, 30...), (100, 200, 300...), (1000, 2000...)
 *       2. How many 1000 are there in num?  (1000 -> "M", 2000 -> "MM", etc)
 *       3. How many 100 are there in num%1000? (100 -> "C", 200 -> "CC", etc)
 *       4. Concatenate the corresponding roman numerals to get the final result
 *      
 */


public class Solution {
    public String intToRoman(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }
}
