/*
 * Problem: https://leetcode.com/problems/insert-interval/
 *
 * Idea:  1. add the new Interval to the list of intervals 
 *        2. sort the intervals
 *        3. merge the list of intervals
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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        return merge(intervals);
    }
    
    private List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();

        // sort the intervals by there start time
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
