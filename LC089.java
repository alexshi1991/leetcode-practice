/*
 * Problem: https://leetcode.com/problems/gray-code/
 *
 * Idea:    1. recursion
 *          2. thought process, if we have the solution to a smaller problem,
 *             how can we get the solution to the current problem size
 *          3. for this problem:
 *             a) the solution to n-1 bits are the subsets of solution to n bits
 *             b) if we retrieve solution to n-1 bits in reverse order,
 *                and add binary '1' to its MSB in binary, we get solution to curr prob
 *          4. visual illustration:
 *             solution to 2 bits:           solution to 3 bits:
 *                   0  0                          0  0  0
 *                   0  1                          0  0  1
 *                   1  1                          0  1  1
 *                   1  0                          0  1  0
 *                                                 1  1  0     
 *                                                 1  1  1
 *                                                 1  0  1
 *                                                 1  0  0
 */

public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        recGrayCode(n, result);
        return result;
    }
    
    private void recGrayCode(int n, List<Integer> result) {
        // base case
        if (n == 0) { result.add(0); }
        else {
            // recursively get gray codes for n-1 bits
            // iterate the returned result in reverse order
            // and add '1' at the MSB, which evaluates to Math.pow(2, n-1) 
            recGrayCode(n - 1, result);
            int prevSize = result.size(); // important to save this size
            for(int i = prevSize - 1; i >= 0; i--) {
                result.add(result.get(i) + (int) Math.pow(2, n-1));
            }
        }
    }
}
