/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
*/

public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        
        String title = "";
        int r = 0;
        int q = n;
        String[] str=new String[26];
        
        // Using character array to increase the run time
        for(int i=0; i<26; i++) {
            str[i] = Character.toString ((char) (i + 65)); 
        }
        
        while(q > 0) {
            
            r = (q-1)%26;
            q = (q-1)/26;
            
            title =  str[r] + "" + title;
        }
            
        return title;
    }
}
