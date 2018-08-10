/*
Let's call an array A a mountain if the following properties hold:

A.length >= 3
There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
*/

class PeakIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] A) {
        int i = 1;
        for (; i < A.length; i++) {
            if (A[i-1] > A[i]) break;
        }
        
        return i-1;
    }
}
