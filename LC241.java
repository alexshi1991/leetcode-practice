/*
 * Problem: https://leetcode.com/problems/different-ways-to-add-parentheses/
 *
 * Idea:    1. divide and conquer 
 *          2. each operator in the input str is a dividing point (divide)
 *          3. after we get possible vals from two smaller problems, 
 *             we combine those vals with the corresponding operator 
 *             to get a list of vals to return for the curr input (conquere)
 *          4. if the input contains only number, then we add itself to ret value list
 *
 */

public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ret = new LinkedList<Integer>();
        for (int i=0; i<input.length(); i++) {
            if (input.charAt(i) == '-' ||
                input.charAt(i) == '*' ||
                input.charAt(i) == '+' ) {
                // divide
                String part1 = input.substring(0, i);
                String part2 = input.substring(i+1);
                List<Integer> part1Ret = diffWaysToCompute(part1);
                List<Integer> part2Ret = diffWaysToCompute(part2);
                // conquer
                for (Integer p1 : part1Ret) {
                    for (Integer p2 : part2Ret) {
                        int c = 0;
                        switch (input.charAt(i)) {
                            case '+': 
                                c = p1+p2;
                                break;
                            case '-': 
                                c = p1-p2;
                                break;
                            case '*': 
                                c = p1*p2;
                                break;
                        }
                        ret.add(c);
                    }
                }
            }
        }
        if (ret.size() == 0) {
            ret.add(Integer.valueOf(input));  // input is a number by itself
        }
        return ret;        
    }
}
