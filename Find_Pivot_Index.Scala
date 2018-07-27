/*
Given an array of integers nums, write a method that returns the "pivot" index of this array.
We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.
If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.
*/

object Solution {
    def pivotIndex(nums: Array[Int]): Int = {
        if (nums == null || nums.length == 0) return -1
        
        var rightsum = nums.reduceLeft[Int](_ + _)
        var leftsum = 0
        
        var i = 0
        for (i <- 0 until nums.length) {
            if (leftsum == rightsum - leftsum - nums(i)) return i
            
            leftsum = leftsum + nums(i)
        }
        
        -1
    }
}
