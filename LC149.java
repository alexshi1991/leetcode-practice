/*
 * Problem:  https://leetcode.com/problems/max-points-on-a-line/
 *
 * Idea:     1. use each point as a reference point
 *           2. calculate slope (y2-y1)/(x2-x1) for every pair of points
 *           3. use String to represent slope (x2 - x1 == 0) ==> "INFINITY"
 *           4. when calculating slope, the denominator needs to be casted to (double)
 *           5. pay special attention to the situation where two points have exact same coordinates
 */


/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) return 0;
        if (points.length == 1) return 1;
        
        Map<String, Integer> slopeCount = new HashMap<>();
        int maxPoints = 2;
        for (int i = 0; i < points.length; i++) {
            // clear the map
            slopeCount.clear();
            Point thisPt = points[i];
            for (Point otherPt : points) {
                if (otherPt != thisPt) {
                    // calculate slope (y2-y1)/(x2-x1)
                    int x1 = thisPt.x;
                    int y1 = thisPt.y;
                    int x2 = otherPt.x;
                    int y2 = otherPt.y;
                    String slope = "INFINITY";
                    if (x2-x1 != 0) {
                        slope = ((y2-y1) / (double)(x2-x1)) + ""; // this double cast is critical
                    }
                    // update slopeCount
                    int newCount = 2;
                    if (slopeCount.containsKey(slope)) {
                        newCount = slopeCount.get(slope) + 1;
                        maxPoints = Math.max(maxPoints, newCount);
                    }
                    slopeCount.put(slope, newCount);
                    
                    // if otherPt and thisPt have exact same coordinates
                    if (x2 == x1 && y2 == y1) {
                        // increment count for every slope except "INFINITY"
                        for (String key: slopeCount.keySet()) {
                            if (!key.equals("INFINITY")) {
                                slopeCount.put(key, slopeCount.get(key)+1);
                                maxPoints = Math.max(maxPoints, slopeCount.get(key));
                            }
                        }
                    }
                }
            }
        }
        
        return maxPoints;
    }
}
