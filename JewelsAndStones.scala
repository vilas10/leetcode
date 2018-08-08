/* https://leetcode.com/problems/jewels-and-stones/description/ */

object JewelsAndStones {
    def numJewelsInStones(J: String, S: String): Int = {
        val jewels = J.split("").toSet
        S.split("").filter(jewels(_)).size
    }
}
