/*
Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
*/
object DegreeOfAnArray {
    def findShortestSubArray(nums: Array[Int]): Int = {
        var leftmap = Map[Int, Int]()
        var rightmap = Map[Int, Int]()
        var countmap = Map[Int, Int]()
        
        var i: Int = 0
        for (i <- 0 until nums.length) {
            val num = nums(i)
            if (!leftmap.contains(num)) leftmap += (num -> i)
            rightmap += (num -> i)
            countmap += (num -> (countmap.getOrElse(num, 0) + 1))
        }
        
        var minlen = nums.length
        val degree = countmap.values.toList.max
        
        countmap.foreach { 
            case (k, v) => if (v == degree) minlen = Math.min(minlen, rightmap(k) - leftmap(k) + 1) 
        }
        
        minlen
    }
    
     
}
