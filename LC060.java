/*
 * Problem: https://leetcode.com/problems/permutation-sequence/
 *
 * Idea:    details in comments
 */

public class Solution {
    public String getPermutation(int n, int k) {
        int pos = 0;
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n+1];
        StringBuilder sb = new StringBuilder();
        
        // create an array of factorial lookup
        int sum = 1;
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
            factorial[i] = sum;
        }
        // factorial[] = {1, 1, 2, 6, 24, ... n!}
        
        // create a list of numbers to get indices
        for (int i=1; i<=n; i++) {
            numbers.add(i);
        }
        
        k--;
        
        // core algorithm: 
        // say n = 4, you have {1, 2, 3, 4}
        // if you were to list out all the permutations you have
        // 1 + (permutations of 2,3,4)
        // 2 + (permutations of 1,3,4)
        // 3 + (permutations of 1,2,4)
        // 4 + (permutations of 1,2,3)
        // We know how to calculate the number of permutations of n numbers...n! 
        // So each of those with permutations of 3 numbers means there are 6 possible permutations.
        // Meaning there would be a total of 24 permutations in this particular one. 
        // So if you were to look for the (k = 14) 14th permutation, it would be in the 
        // 3 + (permutations of 1,2,4) subset ...then the problem repeats itself
        for (int i = 1; i <= n; i++) {
            int index = k/factorial[n-i];
            sb.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            k -= index * factorial[n-i];
        }
        
        return sb.toString();
    }
}
