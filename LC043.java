/*
 * Problem: https://leetcode.com/problems/multiply-strings/
 *
 * Idea:    1. use an auxiliary array to store the result
 *          2. auxiliary array size = len(num1) + len(num2), 99*99 is four digit
 *          3. fill the auxiliary array from right to left with digit-digit multiplication result
 *          4. the multiplication of num1[i] * num2[j] will add to exisiting value of aux[i+j] and aux[i+j+1]
 *          5. the following diagram shows the idea
 *          
 *                             1   2   3
 *                                 4   5
 *                   --------------------
 *                                 1   5 
 *                             1   0
 *                         0   5
 *                             1   2
 *                         0   8
 *                     0   4    
 *                   ---------------------
 *           aux[]     0   5   5   3   5
 */


public class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m+n]; // 99 * 99 can not be five-digit
        
        // order to computer the digit-digit multiply is right -> left
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // multiply two digit
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                // place the result in the pos array
                int sum = mul + pos[i+j+1];
                pos[i+j] += sum / 10;
                pos[i+j+1] = sum % 10;
            }
        }
        
        // output result
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pos.length; i++) {
            // skip the zeros in the front
            if (!(sb.length() == 0 && pos[i] == 0)) {
                sb.append(pos[i]);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}

