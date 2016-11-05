/*
 * Problem: https://leetcode.com/problems/median-of-two-sorted-arrays/
 * 
 * Idea: use binary search to find the perfect cutting points in nums1 and nums2
 *       the two cuts divide the items into left_half and right_half, left_half has
 *       the same (or +1 more) # of items as the right_half, 
 *        and condition max_of_left <= min_of_right holds
 */


public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        // special cases
        if (nums1 == null || nums1.length == 0) { return getMedianSingleArray(nums2); }
        if (nums2 == null || nums2.length == 0) { return getMedianSingleArray(nums1); }
        
        // optimize running time by performing operation on the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        // after binary search, the items in nums1 and nums2 will be divided into two halves: left and right
        int max_of_left = 0, min_of_right = 0;
        
        // do binary search on nums1, time complexity O(log(N))
        int left = 0, right = nums1.length;
        int cut1 = 0, cut2 = 0; // represents cutting points in nums1 and nums2
        while (left <= right) {
            cut1 = (left + (right - left) / 2); // find cut point in nums1
            cut2 = (nums1.length + nums2.length + 1) / 2 - cut1; // computes cut point in nums2 based on cut1
            if (cut1 < nums1.length && nums2[cut2-1] > nums1[cut1]) {
                // cut1 in nums1 is too small, move to the right
                left = cut1 + 1;
            } else if (cut1 > 0 && nums1[cut1-1] > nums2[cut2]) {
                // cut1 in nums1 is too big, move to the left
                right = cut1 - 1;
            } else {
                // we found the perfect cut1, now output the median based on cut1 and cut2
                // the cuts will split the total items in two arrays into left_half and right_half
                // the left_half has the same (or +1) # of items as right_half
                // the max of left_half will be smaller or equal to the min of right_half
                
                // compute maximum number of left half
                if (cut1 == 0) { max_of_left = nums2[cut2-1]; }
                else if (cut2 == 0) { max_of_left = nums1[cut1-1]; }
                else { max_of_left = Math.max(nums1[cut1-1], nums2[cut2-1]); }
                
                // compute minium number of right half
                if (cut1 == nums1.length) { min_of_right = nums2[cut2]; }
                else if (cut2 == nums2.length) { min_of_right = nums1[cut1]; }
                else { min_of_right = Math.min(nums1[cut1], nums2[cut2]); }
                
                // break out of the while loop
                break;
            }
        }
        
        if ((nums1.length + nums2.length) % 2 == 1) {
            return max_of_left; // left half has one more element than right half
        } 
        return (max_of_left + min_of_right) / 2.0; // median is the average of the middle two number
    }
    
    // get median of single array
    private double getMedianSingleArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if (len % 2 == 1) {
            return nums[(len-1)/2];
        } else {
            return (nums[(len-1)/2] + nums[(len-1)/2+1]) / 2.0;
        }
    }
}