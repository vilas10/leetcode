/*
S and T are strings composed of lowercase letters. In S, no letter occurs more than once.

S was sorted in some custom order previously. We want to permute the characters of T so that they match the order that S was sorted. More specifically, if x occurs before y in S, then x should occur before y in the returned string.

Return any permutation of T (as a string) that satisfies this property.
*/
class Solution {
    public String customSortString(String S, String T) {
        char[] arr = S.toCharArray();
        String temp = T;
        String tempS = S;
        int slen = 0;
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < arr.length; i++) {
            int index = temp.indexOf(arr[i]);
            
            if (index == -1) {
                tempS = tempS.substring(0, i - slen) + tempS.substring(i + 1 - slen);
                slen++;
            }
            
            while (index != -1) {    
                temp = temp.substring(0, index) + temp.substring(index + 1);
                index = temp.indexOf(arr[i]);
                sb.append(arr[i]);
            }       
        }
        
        return sb.toString() + temp;
    }
}
