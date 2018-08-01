/*
Alex and Lee play a game with piles of stones.  There are an even number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].

The objective of the game is to end with the most stones.  The total number of stones is odd, so there are no ties.

Alex and Lee take turns, with Alex starting first.  Each turn, a player takes the entire pile of stones from either the beginning or the end of the row.  This continues until there are no more piles left, at which point the person with the most stones wins.

Assuming Alex and Lee play optimally, return True if and only if Alex wins the game.
*/
class Solution {
    public boolean stoneGame(int[] piles) {
        if (piles.length == 2) return true;
        
        int i = 0;
        int j = piles.length - 1;
        int turn = 0;
        int[] sums = new int[2];
        
        while (j - i > 1) {
            int ldiff = piles[i] - piles[i+1];
            int rdiff = piles[j] - piles[j-1];
            
            if (ldiff >= rdiff) {
                sums[turn] = piles[i++];     
            } else {
                sums[turn] = piles[j--];
            }
            
            turn ^= 1;
        }
        
        sums[turn] = Math.max(piles[i], piles[j]);
        turn ^= 1;
        sums[turn] = Math.min(piles[i], piles[j]);
        
        return sums[0] > sums[1];
    }
}
