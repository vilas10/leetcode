/*
Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.
*/

class ShortestDistanceToACharacter {
    public int[] shortestToChar(String S, char C) {
        int[] result = new int[S.length()];
        int index = 0;
        int i = 0;
        
        int first = S.indexOf(C);
        while (first >= 0) {
            System.out.println("first: " + first);
            result[i++] = first--;
        }
                
        while (i < S.length()) {
            int next = S.indexOf(C, i);
            
            int k = 1;
            if (next == -1) {
                while (i < S.length()) {    
                    System.out.println("last k: " + k);

                    result[i++] = k++; 
                }
            } else {
                int curr = next;
                while (i < curr) {
                    System.out.println("k: " + k);
                    result[i++] = k;
                    result[--curr] = k;
                    k++;
                }
                i = next + 1;
            }
        }
        
       return result;
    }
}
