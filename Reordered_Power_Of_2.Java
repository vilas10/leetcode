/*
Starting with a positive integer N, we reorder the digits in any order (including the original order) such that the leading digit is not zero.

Return true if and only if we can do this in a way such that the resulting number is a power of 2.
*/
class Solution {
    public boolean reorderedPowerOf2(int N) {
        if (N == 0) return false;
        if (N == 1) return true;
        if (checkPowerOfTwo(N)) return true;
        
        String num = N + "";
        return permutation(num, 0, num.length() - 1);
    }
    
    public boolean permutation(String num, int left, int right) {
        if (num.charAt(0) == '0') return false;
        
        boolean found = false;
        
        if (left == right) {
            if (checkPowerOfTwo(Integer.parseInt(num))) {
                return true;
            }
        } else {
            for (int i = left; i <= right; i++) {
                num = swap(num, left, i);
                if (permutation(num, left + 1, right)) {
                    found = true;
                    break;
                }
                
                num = swap(num, left, i);
            }
        }
        
        return found;
    }
    
    public boolean checkPowerOfTwo(int num) {
        return (num & (num - 1)) == 0;
    }
    
    public String swap(String num, int i, int j) {
        char[] numarr = num.toCharArray();
        char temp = numarr[i];
        numarr[i] = numarr[j];
        numarr[j] = temp;
        
        return String.valueOf(numarr);
    }
}
