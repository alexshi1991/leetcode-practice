/*
 * Problem: https://leetcode.com/problems/merge-intervals/
 *
 * Idea:    1. Sort the Intervals by their start time
 *          2. Use custom Comparator
 *          3. When merging two Intervals, pay attention to such case: 
 *             merge([2, 10], [6, 9]) = [2, 10]
 */


/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        
        // sort the intervals by their start time
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        
        // go through each interval in the sorted list and 
        // compare each interval's start time with the prev interval's end time
        for (int i = 0; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if (result.isEmpty()) {
                result.add(curr);
                continue;
            }
            Interval prev = result.get(result.size() - 1);
            if (curr.start <= prev.end) {
                prev.end = Math.max(prev.end, curr.end); // merge
            } else {
                result.add(curr);
            }
        }
        
        return result;
    }
}
