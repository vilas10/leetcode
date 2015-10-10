/*
Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
*/

public class Summary_Ranges {
    public List<String> summaryRanges(int[] nums) {
        
        
        if(nums==null)
            return null;
            
        List<String> l=new ArrayList<String>();
        
        if(nums.length==0)
            return l;
        
        if(nums.length==1){
            l.add(""+ nums[0]);
            return l;
        }
        
        int fe=nums[0];
        int le=0;
    
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]+1==nums[i+1]){
                continue;
            }
            
            le=nums[i];
            
            if(fe==le){
                l.add(""+fe);
            }else{
                l.add(fe+"->"+le);
            }
            
            fe=nums[i+1];
            
        }
        le = nums[nums.length-1];
        
        if(fe==le) {
            l.add(""+fe);
        }else{
            l.add(fe+"->"+le);
        }
        
        return l;
    }
}
