/*
 * Problem:  https://leetcode.com/problems/happy-number/
 *
 * Idea:     hashtable
 *
 */

public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (true) {
            int sum = 0;
            while (n > 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            if (sum == 1) return true;
            if (set.contains(sum)) break;
            set.add(sum);
            n = sum;
        }
        return false;        
    }
}
