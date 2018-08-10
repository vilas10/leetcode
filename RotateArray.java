/*
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

[show hint]

Related problem: Reverse Words in a String II
*/

public class RotateArray {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return;
        }
        if(k==0){
            return;
        }
        int temp = 0;
        int temp2=0;
        int flag=0;
        int l = nums.length;
        int cp=0;
        int ncp=0;
        int g=gcd(l,k);
        
        for(int i=0;i<g;i++){
              cp=i;
              while(true){
                ncp=((cp+k)%l);
                
                temp2=nums[ncp];
                
                if(flag==0){
                    nums[ncp]=nums[cp];
                    flag++;
                }else{
                    nums[ncp]=temp;    
                }
                
                temp=temp2;
                
                cp=ncp;
                
                if(cp==i)
                    break;
              }
              flag=0;
        }
    }
        
    public int gcd(int a,int b){
        int rem=0;
        
        if(a<b){
            rem=b%a;
            if(rem==0){
                return a;
            }else{
                return gcd(rem,a);
            }
        }else{
            rem=a%b;
            if(rem==0){
                return b;
            }else{
                return gcd(rem,b);
            }
        }
    }    
    
}
