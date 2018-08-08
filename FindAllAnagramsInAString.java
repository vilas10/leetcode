/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.
*/

class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] counter = new int[26];
        
        char[] parr = p.toCharArray();
        for (int i = 0; i < parr.length; i++) counter[parr[i] - 'a']++;
        
        for (int i = 0; i <= s.length() - parr.length; i++) {
            //String substr = s.substring(i, i + parr.length);
            char[] substrarr = s.substring(i, i + parr.length).toCharArray();
            int[] tempcounter = new int[26];
            boolean flag = true;
            for (int j = 0; j < substrarr.length; j++) {
                int index = substrarr[j] - 'a';
                if (++tempcounter[index] > counter[index]) {
                    flag = false;
                    break; 
                }
            }
            
            if (flag) result.add(i);
        }
        
        return result;
    }
}
