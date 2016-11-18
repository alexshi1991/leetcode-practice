/*
 * Problem: https://leetcode.com/problems/divide-two-integers/
 *
 * Idea: bit manipulation - details below
 */


public class Solution {
    
    /*
     * Why this bit manipulation solution works:
     * Suppose we want to divide 15 by 3, 
     * so 15 is dividend and 3 is divisor. Well, division simply requires us
     * to find how many times we can subtract the divisor from the the dividend
     * without making the dividend negative.
     * 
     * To get started, we subtract 3 from 15 and we get 12, which is
     * positive. Let's try to subtract more. Well, we shift 3 to the left by 1
     * bit and we get 6. Subtracting 6 from 15 still gives a positive result.
     * Well, we shift again and get 12. We subtract 12 from 15 and it is still
     * positive. We shift again, obtaining 24 and we know we can at most
     * subtract 12. Well, since 12 is obtained by shifting 3 to left twice, we
     * know it is 4 times of 3. How do we obtain this 4? Well, we start from 1
     * and shift it to left twice at the same time. We add 4 to an answer
     * (initialized to be 0). In fact, the above process is like 15 = 3 * 4 + 3.
     * We now get part of the quotient (4), with a remainder 3.
     * 
     * Then we repeat the above process again. We subtract divisor = 3 from the
     * remaining dividend = 3 and obtain 0. We know we are done. No shift
     * happens, so we simply add 1 << 0 to the answer.
     */
    
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("divide by zero error");
        }
        long longDividend = (long) dividend;
        long longDivisor = (long) divisor;
        boolean negative = false;
        if (longDividend < 0 && longDivisor > 0) { negative = true; }
        if (longDividend > 0 && longDivisor < 0) { negative = true; }
        long result = 0;
        long sum = 0;
        longDividend = Math.abs(longDividend);
        longDivisor = Math.abs(longDivisor);
        
        // this version uses bit manipulation and is much faster
        while (longDivisor <= longDividend){
            long temp = longDivisor;
            long mul = 1;
            while(longDividend >= (temp << 1)){
                temp <<= 1;
                mul <<= 1;
            }
            longDividend -= temp;
            result += mul;
        }
        
        
        // this version also works, but is slow, exceeds time limit
//        while (sum + longDivisor <= longDividend) {
//            result++;
//            sum += longDivisor;
//        }
        
        result = negative? -result: result;
        
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } 
        return (int) result;
    }
}
