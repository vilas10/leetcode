/*
Description:

Count the number of prime numbers less than a non-negative number, n.
*/

public class Count_Primes {
    public int countPrimes(int n) {
        
        if(n==0 || n==1 || n==2){
            return 0;
        }
        int s=(int)Math.sqrt(n);
        ArrayList<Integer> a=new ArrayList<Integer>();
        a.add(2);
        int i=3;
        boolean f=true;
        int count = 1;
        
        while(i<n){
            for(Integer x:a){
                if(x>s)
                    break;
                if(i%x==0){
                    f=false;
                    break;
                }
            }
            if(f==true){
                count++;
                if(count<= s)
                    a.add(i);
            }else{
                f=true;
            }
            i++;
        }
        
        return count;
    }
}
