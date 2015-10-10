/*
Given an array of integers, find if the array contains any duplicates. 
Your function should return true if any value appears at least twice in the array, and 
it should return false if every element is distinct.
*/

public class Contains_Duplicate {
    public boolean containsDuplicate(int[] nums) {
        
        HashSet<Integer> t=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            if(t.contains(nums[i])){
                return true;
            }else{
                t.add(nums[i]);
            }
        }
        
        return false;
    }
}
