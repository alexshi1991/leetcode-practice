/*
 * Problem: https://leetcode.com/problems/expression-add-operators/
 *
 * Idea:    1. backtracking, recursion
 *          2. keep track of current evaluation result
 *          3. also need to separately keep track of last consecutive multiplication result
 *
 */

public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) return result;
        findExpr(result, "", num, target, 0, 0, 0);
        return result;
    }
    
    private void findExpr(List<String> result, String currExpr, String num, int target, int pos, long eval, long multed) {
        if (pos == num.length()) {
            if (target == eval) {
                result.add(currExpr);
            }
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') break;
            long nextNum = Long.parseLong(num.substring(pos, i+1));
            if (pos == 0) {
                findExpr(result, currExpr + nextNum, num, target, i + 1, nextNum, nextNum);
            } else {
                findExpr(result, currExpr + "+" + nextNum, num, target, i + 1, eval + nextNum, nextNum);
                findExpr(result, currExpr + "-" + nextNum, num, target, i + 1, eval - nextNum, -nextNum);
                findExpr(result, currExpr + "*" + nextNum, num, target, i + 1, eval - multed + multed * nextNum, multed * nextNum);
            }
        }
    }
}
