/*
Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.
*/
class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> mySet = new HashSet<String>(Arrays.asList(banned));
        
        String[] words = paragraph.split("[!?',;.]+\\s*|\\s+");
        Map<String, Integer> map = new HashMap<>();
        
        int max = 0;
        String cword = "";

        for (int i = 0; i < words.length; i++) {
            String curr = words[i].toLowerCase();

            if (!curr.equals("") && !mySet.contains(curr)) {
                int count = 0;
                if (map.containsKey(curr)) {
                    count = map.get(curr) + 1;
                    map.put(curr, count);
                } else {
                    count = 1;
                    map.put(curr, count);
                }
                
                if (max < count) {
                    cword = curr;
                    max = count;
                }
            }
        }
        
        return cword;
    }
}
