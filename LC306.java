/*
 * Problem:  https://leetcode.com/submissions/detail/89885207/
 *
 * Idea:     backtracking / recursion
 */

import java.math.BigInteger;

public class Solution {
    public boolean isAdditiveNumber(String num) {
        List<BigInteger> sequence = new ArrayList<>();
        return isAdditive(sequence, num);
    }
    
    private boolean isAdditive(List<BigInteger> sequence, String num) {
        int size = sequence.size();
        BigInteger last = new BigInteger("-1");
        BigInteger oneBeforeLast = new BigInteger("-1"); // not assigned
        if (size >= 1) last = sequence.get(size-1);
        if (size >= 2) oneBeforeLast = sequence.get(size-2);

        // base cases
        if (num.equals("")) return false;
        if (sequence.size() >= 2) {
            boolean satisfy = false, leadingZero = false;
            if ((new BigInteger(num)).equals(last.add(oneBeforeLast))) {
                satisfy = true;
            }
            if (num.length() > 1 && num.charAt(0) == '0') {
                leadingZero = true;
            }
            if (satisfy && !leadingZero) return true;
        }

        for (int i = 1; i <= num.length(); i++) {
            String numStr = num.substring(0, i);
            if (numStr.length() > 1 && numStr.charAt(0) == '0') continue; // num can not have leading zero
            BigInteger nextNum = new BigInteger(numStr);
            if (size >= 2 && !nextNum.equals(last.add(oneBeforeLast))) {
                continue;  // does not satisfy additive requirement
            }
            sequence.add(nextNum);
            if (isAdditive(sequence, num.substring(i))) return true;
            sequence.remove(sequence.size()-1); // backtracking
        }
        return false;
    }    
}
