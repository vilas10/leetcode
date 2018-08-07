/*
https://leetcode.com/problems/simplify-path/description/
*/
public class Solution {
    public String simplifyPath(String path) {
        StringBuilder simplified = new StringBuilder();
        simplified.append("/");
        
        String[] patharray = path.split("/");
        Stack<Integer> stack = new Stack<Integer>();
        
        int prev = 0;
        for(int i=0; i<patharray.length; i++) {
            if(patharray[i].equals(".") || patharray[i].isEmpty()) {
                continue;
            } else if(patharray[i].equals("..")) {
                if(simplified.length() != 1) {
                    if(!stack.isEmpty()) {
                        prev = stack.pop();
                    }
                    simplified.delete(simplified.length()-prev, simplified.length());
                    prev = 0;
                }
            } else {
                simplified.append(patharray[i] + "/");
                stack.push(patharray[i].length() + 1);
            }
        }
        
        if(simplified.length() == 1) {
            return simplified.toString();
        }
        
        return simplified.substring(0,simplified.length()-1);
    }
} 
