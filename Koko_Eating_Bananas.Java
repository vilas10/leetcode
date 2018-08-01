/*
Koko loves to eat bananas.  There are N piles of bananas, the i-th pile has piles[i] bananas.  The guards have gone and will come back in H hours.

Koko can decide her bananas-per-hour eating speed of K.  Each hour, she chooses some pile of bananas, and eats K bananas from that pile.  If the pile has less than K bananas, she eats all of them instead, and won't eat any more bananas during this hour.

Koko likes to eat slowly, but still wants to finish eating all the bananas before the guards come back.

Return the minimum integer K such that she can eat all the bananas within H hours.
*/
class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int min = IntStream.of(piles).min().getAsInt();
        int maxspeed = IntStream.of(piles).max().getAsInt();
        long sum = 0;
        for (int i = 0; i < piles.length; i++) {
            sum += piles[i];
        }
        //int sum = IntStream.of(piles).sum();
        int minspeed = (int) Math.ceil(sum / H);
        if (minspeed == 0) minspeed++;
        
        while (minspeed <= maxspeed) {
            int h = 0;
            int i = 0;         
            while (i < piles.length && h <= H) {
                int hrs = piles[i] / minspeed;
                h += piles[i] % minspeed == 0 ? hrs : hrs + 1;
                i++;
            }
            
            if (i == piles.length && h <= H) return minspeed;
            minspeed++;
        }
        
        return 0;
    }
}
