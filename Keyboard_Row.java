/*
Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.

American keyboard


*/

public class Solution {
    public String[] findWords(String[] words) {
        Set<String> row1 = new HashSet<String>(Arrays.asList("Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P"));
        Set<String> row2 = new HashSet<String>(Arrays.asList("A", "S", "D", "F", "G", "H", "J", "K", "L"));
        Set<String> row3 = new HashSet<String>(Arrays.asList("Z", "X", "C", "V", "B", "N", "M", "I", "O"));
        
        Boolean flag1 = true;
        Boolean flag2 = true;
        Boolean flag3 = true;
        
        List<String> result = new ArrayList<String>();
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i].toUpperCase();
            
            for (int j = 0; j < word.length() && (flag1 || flag2 || flag3); j++) {
                String curr = word.charAt(j) + "";
                
                if (flag1 && !row1.contains(curr)) flag1 = false;
                if (!flag1 && flag2 && !row2.contains(curr)) flag2 = false;
                if (!flag1 && !flag2 && flag3 && !row3.contains(curr)) flag3 = false;
            }
            
            if (flag1 || flag2 || flag3) result.add(words[i]); 
            flag1 = flag2 = flag3 = true;
        }
        
        String[] resultArray = new String[result.size()];

        return result.toArray(resultArray);
    }
}
