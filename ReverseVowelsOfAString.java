/*
Write a function that takes a string as input and reverse only the vowels of a string.
*/

public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        char[] sarray = s.toCharArray();
        
        int i = 0;
        int j = sarray.length - 1;
        List<String> vowels = new ArrayList<String>(Arrays.asList("a", "e", "i", "o", "u", "A", "E", "I", "O", "U"));
        
        while (i < j) {
            if (!vowels.contains("" + sarray[i]) && !vowels.contains("" + sarray[j])) {
                i++; j--;
            } else if (vowels.contains("" + sarray[i]) && vowels.contains("" + sarray[j])) {
                char temp = sarray[i];
                sarray[i] = sarray[j];
                sarray[j] = temp;
                i++; j--;
            } else if (vowels.contains("" + sarray[i])) {
                j--;
            } else {
                i++;
            }
        }
  
        return new String(sarray);
    }
}
