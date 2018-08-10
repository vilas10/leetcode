/*
Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
*/
object ReverseStringII {
    def reverseStr(s: String, k: Int): String = {        
        if (s == null || k <= 1) 
            s
        else if (k >= s.length()) {
            s.reverse
        } else {
            var i = 0
            var result = ""

            for (i <- 0 until s.length() by 2 * k) {                
                result += s.slice(i, i + k).reverse                
                result += s.slice(i + k, i + 2 * k)
            }
            
            result
        }
    }
}
