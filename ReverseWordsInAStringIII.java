/*
Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
*/

object ReverseWordsInAStringIII {
    def reverseWords(s: String): String = {
        if (s == null)
            null
        else
            s.trim.split("\\s+").map(word => word.reverse) mkString " "
    }    
}
