/*
 * Problem:  https://leetcode.com/problems/h-index/
 *
 * Idea:     two different approaches, one uses sorting, one uses extra space
 */


public class Solution {
    // sort the array, O(NlgN), no extra space
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int hIdx = 0;
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= (citations.length - i)) {
                hIdx = citations.length - i;
                break;
            }
        }
        return hIdx;
    }

    // sort the array, use binary search after sorting the array
    public int hIndex(int[] citations) {
        int hIndex = 0;
        if (citations == null || citations.length == 0) return hIndex;
        int left = 0, right = citations.length - 1;
        int mid;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (citations[mid] >= (citations.length - mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (citations[left] >= citations.length - left) {
            hIndex = citations.length - left;
        } else if (citations[right] >= citations.length - right) {
            hIndex = citations.length - right;
        }
        return hIndex;
    }
    
    // faster approach O(N), use extra space
    public int hIndex(int[] citations) {
        int len = citations.length;
        int[] count = new int[len+1]; // possible hIndex values are 0,1,...len
        for (int c: citations) {
            if (c > len) count[len]++; 
            else count[c]++;
        }
        int sum = 0;
        for (int i = len; i >= 0; i--) {
            sum += count[i];
            if (sum >= i) return i;
        }
        return 0;
    }
}