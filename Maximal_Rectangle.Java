/*
https://leetcode.com/problems/maximal-rectangle/description/
*/
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }
        
        int[] heights = new int[matrix[0].length];
        
        int maxarea = 0;
            
        for(int j=0; j<matrix.length; j++) {
            Stack<Integer> stack = new Stack<Integer>();
            int area = 0;
            
            for(int i=0; i<heights.length; i++) {
                if(matrix[j][i] == '1') {
                    heights[i]++;
                } else {
                    heights[i] = 0;
                }
            }
            
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
        }
        
        return maxarea;
    }
}
