/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.
*/

public class Solution {
    public int maxArea(int[] height) {
        if(height.length == 0 || height.length == 1) {
            return 0;
        }
        
        int maxArea=0;
        int l=0;
        int r=height.length-1;
        
        while(l!=r){
            
            if(height[l] < height[r]){
                if(maxArea < (height[l]*(r-l)))
                    maxArea = height[l]*(r-l);
                l++;
            }else{
                if(maxArea<(height[r]*(r-l)))
                    maxArea=height[r]*(r-l);
                r--;
            }
            
        }
        
        return maxArea;
    }
}
