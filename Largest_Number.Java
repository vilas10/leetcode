/*
https://leetcode.com/problems/largest-number/description/
*/
class Solution {
    public String largestNumber(int[] nums) {
        String[] numstrs = new String[nums.length];
        
        for (int i = 0; i < nums.length; i++) numstrs[i] = new String(nums[i] + "");
        
        for (int i = 0; i < numstrs.length; i++) {
            for (int j = i+1; j < numstrs.length; j++) {
                String ab = numstrs[i] + numstrs[j];
                String ba = numstrs[j] + numstrs[i];
                if (ab.compareTo(ba) > 0) {
                    String temp = numstrs[i];
                    numstrs[i] = numstrs[j];
                    numstrs[j] = temp;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = numstrs.length - 1; i >= 0; i--) sb.append(numstrs[i]);
        
        return sb.toString().charAt(0) == '0'? "0" : sb.toString();
    }
}
