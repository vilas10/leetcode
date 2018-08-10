/*
A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
*/
class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        Set<Character> visited = new HashSet<Character>();
        char[] arr = S.toCharArray();
        List<Integer> result = new ArrayList<>();
        
        int start = 0;
        int end = S.length();
        
        for (int i = 0; i < arr.length; i++) {
            char curr = arr[i];
            
            if (i < end && !visited.contains(curr)) {
                visited.add(curr);
                
                int last = S.lastIndexOf(curr);
                
                if (start == i) {
                    if (start == last) {
                        result.add(1);
                        start++;
                        end = S.length();
                    } else {
                        end = last;
                    }
                } else {
                    if (last > end) {
                        end = last;
                    }
                }
            } else if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
                end = S.length();
            }
        }
        
        return result;   
    }
}
