/*
https://leetcode.com/problems/largest-rectangle-in-histogram/description/
*/
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        int area = 0;
        int maxarea = 0;
        int count = 0;
        int min = Integer.MAX_VALUE;
            
        for(int i=0; i<heights.length; i++) {
            if(stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i);
                continue;
            }
            
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int top = stack.pop();
                int nexttop = 0;
                if(!stack.isEmpty()) {
                    nexttop = stack.peek() + 1;
                }
                area = (i - nexttop) * heights[top];
                if(maxarea < area) {
                    maxarea = area;
                }
            }
            
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            int top = stack.pop();
            
            int nexttop = 0;
            if(!stack.isEmpty()) {
                nexttop = stack.peek() + 1;
            }
            
            area = (heights.length - nexttop) * heights[top];
            if(maxarea < area) {
                maxarea = area;
            }
        }
        
        return maxarea;
    } 
}
