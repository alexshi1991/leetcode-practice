/*
 * Problem:  https://leetcode.com/problems/count-primes/
 *
 * Idea:     1. use an boolean array to track if each number is a prime
 *           2. initialize every number to be prime
 *           3. when finding a prime number (starting from 2), mark all its multiples to be "not a prime"
 *           4. O(n) running time and O(n) memory
 *
 */


public class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n+1]; // n+1 for indexing convenience
        for (int i = 0; i < n + 1; i++) {
            isPrime[i] = true; // initialize all numbers to be prime
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i] == true) {
                count++;
                // mark all its multiples not a prime
                for (int j = 2; j * i < n; j++) {
                    isPrime[j * i] = false;
                }
            }
        }
        return count;
    }
}
