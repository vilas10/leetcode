/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
*/
public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> combis = new ArrayList<String>();
        if(digits == null || digits.length() == 0) {
            return combis;
        }
        
        StringBuilder combi = new StringBuilder();
        String[] dtol = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        letterCombinations(digits, dtol, combis, combi, 0);
        
        return combis;
    }
    
    void letterCombinations(String digits, String[] dtol, List<String> combis, StringBuilder combi, int start) {
        if(start == digits.length()) {
            combis.add(combi.toString());
            return;
        }
        
        for(int i=start; i<start+1; i++) {
            int digit = digits.charAt(i) - '0';
            for(int j=0; j<dtol[digit].length(); j++) {
                combi.append(dtol[digit].charAt(j));
                letterCombinations(digits, dtol, combis, combi, start+1);
                combi.deleteCharAt(combi.length() - 1);
            }
        }
    }
}
