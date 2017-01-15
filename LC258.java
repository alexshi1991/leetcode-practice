/*
 * Problem:  https://leetcode.com/problems/add-digits/
 *
 * Idea:     naive implementation  vs. clever math O(1) time
 *
 */

public class Solution {
    // solve the problem by its definition, no clever trick
    public int addDigits(int num) {
        int res = num;
        while (num / 10 > 0) {
            res = 0;
            while (num > 0) {
                res += num % 10;
                num /= 10;
            }
            num = res;
        }
        return res;
    }
    
    // mathematically derived formula (digit root problem)
    public int addDigits(int num) {
        return 1 + (num - 1) % 9;
    }
    
}
