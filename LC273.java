/*
 * Problem:  https://leetcode.com/problems/integer-to-english-words/
 *
 * Idea:     count # of Billion, # of Million, # of Thousand, ... + recursion on the count if necessary
 *
 */

public class Solution {
    
    static final String[] names = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
                     "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
                     "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    static final String[] tens = {"Zero", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
                     "Eighty", "Ninety"};
    static final int ONE_BILLION = 1000000000;
    static final int ONE_MILLION = 1000000;
    static final int ONE_THOUSAND = 1000;
    static final int ONE_HUNDRED = 100;
    
    public String numberToWords(int num) {
        
        if (num == 0) return "Zero"; // special case
        
        StringBuilder sb = new StringBuilder();
        
        if (num >= ONE_BILLION) {  
            int billionCtr = num / ONE_BILLION; // at most 2 billion
            sb.append(names[billionCtr]  + " Billion ");  
            num -= billionCtr * ONE_BILLION;
        }
        if (num >= ONE_MILLION) {  
            int millionCtr = num / ONE_MILLION; // 1~999 
            sb.append(numberToWords(millionCtr) + " Million ");
            num -= millionCtr * ONE_MILLION;
        }
        if (num >= ONE_THOUSAND) { 
            int thousandCtr = num / ONE_THOUSAND; // 1~999
            sb.append(numberToWords(thousandCtr) + " Thousand ");
            num -= thousandCtr * ONE_THOUSAND;
        }
        if (num >= ONE_HUNDRED) {
            int hundredCtr = num / ONE_HUNDRED; // 1~9
            sb.append(names[hundredCtr] + " Hundred ");
            num -= hundredCtr * ONE_HUNDRED;
        }
        if (num >= 20) {
            int tenCtr = num / 10; // 2~9
            sb.append(tens[tenCtr] + " ");
            num -= tenCtr * 10;
            if (num > 0) {
                sb.append(names[num] + " ");
            }
        } else {
            if (num > 0) {
                sb.append(names[num] + " "); // if num less than 20, get ans from look-up table
            }
        }
        
        return sb.toString().trim();
    }
}
