/*
Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
Please note that the string does not contain any non-printable characters.
*/

object NumberOfSegmentsInaString {
    def countSegments(s: String): Int = {
        Option(s) match {
            case Some(str) => val trimmed = str.trim
            if (trimmed.length() == 0)
                0
            else
                trimmed.split("\\s+").length
            case None => -1
        }
    }
}
