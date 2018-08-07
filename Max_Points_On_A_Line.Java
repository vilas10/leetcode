/*
https://leetcode.com/problems/max-points-on-a-line/description/
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
        if(points == null || points.length == 0) {
            return 0;
        }
        
        int max = 0;
        
        for(int i=0; i<points.length; i++) {
            HashMap<Double, Integer> map = new HashMap<Double, Integer>();
            int samex = 1;
            int coincide = 0;
            
            for(int j=0; j<points.length; j++) {
                if(j != i) {
                    double x = points[i].x - points[j].x;
                    double y = points[i].y - points[j].y;
                
                    if(x == 0 && y == 0) {
                        coincide++;
                    }
                
                    if(x == 0) {
                        samex++;
                        continue;
                    }
                    
                    double s = y/x;
                
                    if(map.get(s) == null) {
                        map.put(s, 2);
                    } else {
                        map.put(s, map.get(s) + 1);
                    }
                
                    max = Math.max(max, map.get(s) + coincide);
                }
            }
            
            max = Math.max(max, samex);
        }
        
        return max;
    }
}
