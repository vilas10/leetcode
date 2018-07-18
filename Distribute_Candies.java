/*
Given an integer array with even length, where different numbers in this array represent different kinds of candies. Each number means one candy of the corresponding kind. You need to distribute these candies equally in number to brother and sister. Return the maximum number of kinds of candies the sister could gain.
*/

class Solution {
    public int distributeCandies(int[] candies) {
        Set<Integer> distinctCandies = new HashSet<Integer>();
        
        for (int c: candies) distinctCandies.add(c);
        
        if (distinctCandies.size() >= candies.length/2) 
            return candies.length/2;
        else 
            return distinctCandies.size();
    }
}
