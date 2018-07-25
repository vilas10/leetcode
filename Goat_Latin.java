/*
A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.

We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)

The rules of Goat Latin are as follows:

If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
For example, the word 'apple' becomes 'applema'.
 
If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
For example, the word "goat" becomes "oatgma".
 
Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
Return the final sentence representing the conversion from S to Goat Latin.
*/

class Solution {
    StringBuilder sb1 = new StringBuilder();
    
    public String toGoatLatin(String S) {
        String[] words = S.split(" ");
        StringBuilder sb = new StringBuilder();
        Set<String> vowels = new HashSet<>(Arrays.asList("a", "e", "i", "o", "u", "A", "E", "I", "O", "U"));
        
        
        for (int i = 0; i < words.length; i++) {
            String first = words[i].charAt(0) + "";
            
            if (vowels.contains(first)) {
                sb.append(words[i] + "ma");
            } else {
                sb.append(words[i].substring(1) + first + "ma");
            }
            
            sb.append(aString(i + 1));
            sb.append(" ");
        }
        
        String goatLatin = sb.toString();
        
        return goatLatin.substring(0, goatLatin.length() - 1);
    }
    
    public String aString(int len) {
        sb1.setLength(0);
        
        for (int i = 0; i < len; i++) {
            sb1.append("a");
        }
        
        return sb1.toString();
    }
}
