/*
You're now a baseball game point recorder.

Given a list of strings, each string can be one of the 4 following types:

Integer (one round's score): Directly represents the number of points you get in this round.
"+" (one round's score): Represents that the points you get in this round are the sum of the last two valid round's points.
"D" (one round's score): Represents that the points you get in this round are the doubled data of the last valid round's points.
"C" (an operation, which isn't a round's score): Represents the last valid round's points you get were invalid and should be removed.
Each round's operation is permanent and could have an impact on the round before and the round after.

You need to return the sum of the points you could get in all the rounds.
*/

object Solution {
    def calPoints(ops: Array[String]): Int = {
        var arr = List[Int]()
        
        ops foreach { x => x match {
            case "C" => 
                arr = arr.drop(1)
            case "D" => 
                arr = arr.head * 2 :: arr
            case "+" =>
                val last2 = arr.take(2)
                arr = (last2.head + last2.last) :: arr
            case score =>
                arr = score.toInt :: arr
            case _ =>
        }
        }
        
        arr.sum
    }
}
