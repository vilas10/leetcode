/*
To some string S, we will perform some replacement operations that replace groups of letters with new ones (not necessarily the same size).

Each replacement operation has 3 parameters: a starting index i, a source word x and a target word y.  The rule is that if x starts at position i in the original string S, then we will replace that occurrence of x with y.  If not, we do nothing.

For example, if we have S = "abcd" and we have some replacement operation i = 2, x = "cd", y = "ffff", then because "cd" starts at position 2 in the original string S, we will replace it with "ffff".

Using another example on S = "abcd", if we have both the replacement operation i = 0, x = "ab", y = "eee", as well as another replacement operation i = 2, x = "ec", y = "ffff", this second operation does nothing because in the original string S[2] = 'c', which doesn't match x[0] = 'e'.

All these operations occur simultaneously.  It's guaranteed that there won't be any overlap in replacement: for example, S = "abc", indexes = [0, 1], sources = ["ab","bc"] is not a valid test case.
*/

class FindAndReplaceInString {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < indexes.length; i++) {
            map.put(indexes[i], i);
        }
        
        Arrays.sort(indexes);
        
        for (int i = 0; i < indexes.length; i++) {
            if (index < indexes[i]) {
                sb.append(S.substring(index, indexes[i]));
                index = indexes[i];
            }
            
            int oldIndex = map.get(indexes[i]);
            
            if (S.substring(indexes[i], indexes[i] + sources[oldIndex].length()).equals(sources[oldIndex])) {
                sb.append(targets[oldIndex]);
                index = indexes[i] + sources[oldIndex].length();
            }
        }
        
        if (index < S.length()) {
            sb.append(S.substring(index, S.length()));
        }
        
        return sb.toString();
    }
}
