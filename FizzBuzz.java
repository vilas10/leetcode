/*
Write a program that outputs the string representation of numbers from 1 to n.

But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
*/

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> fz = new ArrayList<String>();
        
        for (int x=1; x <= n; x++) {
            
            String fizzbuzz = (x % 3 == 0 ? "Fizz" : "") + (x % 5 == 0 ? "Buzz" : "");
            
            if (fizzbuzz.equals("")) 
                fz.add(x-1, "" + x);
            else 
                fz.add(x-1, fizzbuzz);
        }
        
        return fz;
    }
}
