/*
You have a list of points in the plane. Return the area of the largest triangle that can be formed by any 3 of the points.
*/

class Solution {
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double maxArea = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    maxArea = Math.max(maxArea, triangleArea(points[i], points[j], points[k]));
                }
            }
        }
        
        return maxArea;
    }
    
    public double triangleArea(int[] a, int[] b, int[] c) {
        return 0.5 * Math.abs(a[0] * (b[1] - c[1]) + b[0] * (c[1] - a[1]) + c[0] * (a[1] - b[1]));
    }
}
