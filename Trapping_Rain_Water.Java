/*
https://leetcode.com/problems/trapping-rain-water/description/
*/
public class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }
        int len = height.length;
        int[] maxLeft = new int[len];
        int[] maxRight = new int[len];
        
        for(int i=len-1, rmax=0; i>=0; i--) {
            if(rmax < height[i]) {
                rmax = height[i];
                maxRight[i] = rmax;
            } else {
                maxRight[i] = rmax;
            }
        }
        
        int water = 0;
        int lmax = height[0];
        
        for(int i=0; i<len; i++) {
            water += Math.max((Math.min(lmax, maxRight[i]) - height[i]), 0);
            if(lmax < height[i]) {
                lmax = height[i];
            }
        }
        
        return water;
    }
}
