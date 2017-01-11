/*
 * Problem: https://leetcode.com/problems/product-of-array-except-self/
 *
 * Idea:    for each elem: 
 *          1) compute product of all elems left of curr elem
 *          2) compute product of all elems right of curr elem
 *          3) multiply the two product
 *
 */

public class Solution {
    
    // solution without extra space
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int len = nums.length;
        int[] result = new int[len];
        
        // get product from all elems left of curr elem
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                result[i] = 1;
            } else {
                result[i] = result[i-1] * nums[i-1];
            }
        }
        
        // get product from all elems right of curr elem 
        // (and multiply it with existing entries)
        int right = 1;
        for (int i = len - 1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }
        
        return result;
    }
    
    // solution using extra space
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int len = nums.length;
        int[] result = new int[len];
        int[] productFromLeft = new int[len];
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                productFromLeft[i] = 1;
            } else {
                productFromLeft[i] = productFromLeft[i-1] * nums[i-1];
            }
        }
        int[] productFromRight = new int[len];
        for (int j = len - 1; j >= 0; j--) {
            if (j == len - 1) {
                productFromRight[j] = 1;
            } else {
                productFromRight[j] = productFromRight[j+1] * nums[j+1];
            }
        }
        
        int[] product = new int[len];
        for (int k = 0; k < len; k++) {
            product[k] = productFromLeft[k] * productFromRight[k];
        }
        
        return product;
    }
    
}
