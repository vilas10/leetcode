/*
There are N dominoes in a line, and we place each domino vertically upright.

In the beginning, we simultaneously push some of the dominoes either to the left or to the right.



After each second, each domino that is falling to the left pushes the adjacent domino on the left.

Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.

When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.

For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.

Given a string "S" representing the initial state. S[i] = 'L', if the i-th domino has been pushed to the left; S[i] = 'R', if the i-th domino has been pushed to the right; S[i] = '.', if the i-th domino has not been pushed.
*/
class Solution {
    public String pushDominoes(String dominoes) {
        StringBuilder sb = new StringBuilder(dominoes);
        int start = -1;
        char prev = '.';
        int i = 0;
        
        while (i < sb.length()) {
            if (start == -1 && sb.charAt(i) == 'L') {
                replace(sb, 0, i, 'L');
                prev = 'L';
                start = i + 1;
            } else if (i == sb.length() - 1 && sb.charAt(i) == '.' && prev == 'R') {
                replace(sb, start, sb.length(), 'R');
            } else if (sb.charAt(i) != '.') {
                if (sb.charAt(i) == prev) {
                    replace(sb, start, i, prev);
                } else if (prev == 'R') {
                    int mid = (i + start) / 2;

                    if ((i - start) % 2 == 0) {
                        replace(sb, start, mid, 'R');
                        replace(sb, mid + 1, i, 'L');
                    } else {
                        replace(sb, start, mid + 1, 'R');
                        replace(sb, mid + 1, i, 'L');
                    }
                }
                
                prev = sb.charAt(i);
                start = i;
            }
            
            i++;
        }
        
        return sb.toString();
    }
    
    public void replace(StringBuilder sb, int begin, int end, char c) {
        for (int i = begin; i < end; i++) {
            sb.setCharAt(i, c);
        }
    }
}
