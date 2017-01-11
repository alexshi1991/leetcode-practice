/*
 * Problem: https://leetcode.com/problems/number-of-digit-one/
 *
 * Idea:    count # of 1 on every digit
 *          example: if we want to calculate how many 1s on the hundred's digit for xyabc,
 *          
 *                   count += xy * 100; 
 *                   count += bc + 1; (if a == 1)  (xy100 - xy1bc)
 *                   count += 100;  (if a > 1)   
 *
 */

public class Solution {
    public int countDigitOne(int n) {
        if (n <= 0) return 0;
        int q = n, x = 1, ans = 0;
        do {
            int digit = q % 10;
            q /= 10;
            ans += q * x;
            if (digit == 1) ans += n % x + 1;
            if (digit > 1) ans += x;
            x *= 10;
        } while (q > 0);
        return ans;        
    }
}
