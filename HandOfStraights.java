/*
Alice has a hand of cards, given as an array of integers.

Now she wants to rearrange the cards into groups so that each group is size W, and consists of W consecutive cards.

Return true if and only if she can.
*/
class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0) return false;
        
        Arrays.sort(hand);
        boolean[] visited = new boolean[hand.length];
        
        int count = 0;
        int groups = hand.length / W;
        int start = 0;
        int prevstart = start;
        int prev = -1;
        
        while (groups > 0) {
            if (visited[start]) {
                System.out.println("visited[start=" + start + "]=true");
                return false;
            } else {
                visited[start] = true;
                count++;
                System.out.println("i=" + start + "\tval=" + hand[start]);
                prev = start;
            }
            
            int i = start + 1;
            for (; count < W && i < hand.length; i++) {
                if (!visited[i]) {
                    if (hand[i] == hand[prev] + 1) {
                        count++;
                        prev = i;
                        visited[i] = true;
                        System.out.println("i=" + i + "\tval=" + hand[i]);
                    } else if (start == prevstart) {
                        start = i;
                    }
                }
            }
            
            if (count != W) {
                System.out.println("count != W");
                return false;
            }
            
            if (start == prevstart) {
                start = i;
            }
            
            prevstart = start;
            groups--;
            count = 0;
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) return false;
        }
        
        return true;
    }
}
