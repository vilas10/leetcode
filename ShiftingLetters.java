/*
We have a string S of lowercase letters, and an integer array shifts.

Call the shift of a letter, the next letter in the alphabet, (wrapping around so that 'z' becomes 'a'). 

For example, shift('a') = 'b', shift('t') = 'u', and shift('z') = 'a'.

Now for each shifts[i] = x, we want to shift the first i+1 letters of S, x times.

Return the final string after all such shifts to S are applied.

Example 1:

Input: S = "abc", shifts = [3,5,9]
Output: "rpl"
Explanation: 
We start with "abc".
After shifting the first 1 letters of S by 3, we have "dbc".
After shifting the first 2 letters of S by 5, we have "igc".
After shifting the first 3 letters of S by 9, we have "rpl", the answer.
Note:

1 <= S.length = shifts.length <= 20000
0 <= shifts[i] <= 10 ^ 9
*/
class ShiftingLetters {
    public String shiftingLetters(String S, int[] shifts) {
        long[] actualShifts = new long[shifts.length];
        actualShifts[shifts.length - 1] = shifts[shifts.length - 1];
        for (int i = shifts.length - 2; i >= 0; i--) {
            actualShifts[i] = actualShifts[i+1] + shifts[i];
        }
        
        char[] arr = S.toCharArray();
        
        for (int i = 0; i < shifts.length; i++) {
            long effectiveShifts = ((arr[i] - 'a') + actualShifts[i]) % 26;
            arr[i] = (char) (effectiveShifts + 'a');
        }
        
        return String.valueOf(arr);
    }
}
