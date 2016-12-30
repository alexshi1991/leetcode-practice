/*
 * Problem: https://leetcode.com/problems/fraction-to-recurring-decimal/
 *
 * Idea:    1. long division
 *          2. use hashmap to track <remainder, fractionalPart.length()>
 *          3. find integral part, non-repeating fractioanlPart and repeating fractionalPart
 *
 */

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
    	// use long type to avoid overflow
    	long numer = (long) numerator;
    	long denom = (long) denominator;
    	
    	// corner case
    	if (numer == 0 || denom == 0) return "0";
    	
    	// program should be able to handle negative numbers
    	boolean negative = (numer * denom) < 0? true: false;
    	String sign = "";
    	if (negative) sign = "-";
    	
    	// get the absolute value
    	numer = Math.abs(numer);
    	denom = Math.abs(denom);
    	
        // first get the integral part
        String result = numer / denom + "";
        long remainder = numer % denom;
        if (remainder != 0) {
            result += ".";
        } else {
            return sign + result;
        }
        
        // construct a hash table, key is the remainder, value is the current length of the fractional part
        // value is used to split the non-repeating part and the repeating part
        HashMap<Long, Integer> remainderMap = new HashMap<Long, Integer>();
        
        // a long division procedure to get the repeating fractional part
        // result is obtained when the remainder starts to repeat or equals 0 (i.e no repeating part)
        long currNumerator = remainder;
        boolean repeating = true;
        StringBuilder fractionalPart = new StringBuilder();
        while (!remainderMap.containsKey(remainder)) {
        	remainderMap.put(remainder, fractionalPart.length());
            currNumerator = 10 * remainder;
            fractionalPart.append(currNumerator / denom + "");
            remainder = currNumerator % denom;
            if (remainder == 0) {
                repeating = false;
                break;
            }
        }
        
        // return the final result
        String fractionalPartStr = fractionalPart.toString();
        if (repeating) {       	
        	String nonRepeatingPart = fractionalPartStr.substring(0, remainderMap.get(remainder));
        	String repeatingPart = fractionalPartStr.substring(remainderMap.get(remainder));
            return sign + result + nonRepeatingPart + "(" + repeatingPart + ")";
        } else {
            return sign + result + fractionalPartStr;
        }        
    }
}
