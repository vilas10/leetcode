/*
Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.

Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
*/

public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 1;

        while (n > 0 && i < flowerbed.length) {
            if (flowerbed[i] == 0) {
                if (flowerbed[i-1] == 0) n--;
                i += 2;
            } else {
                i += 3;
            }
        }
        
        if (i == flowerbed.length && flowerbed[i-1] == 0) n--;
        
        return n <= 0;
    }
}
