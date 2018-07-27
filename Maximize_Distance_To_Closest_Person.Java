/*
In a row of seats, 1 represents a person sitting in that seat, and 0 represents that the seat is empty. 

There is at least one empty seat, and at least one person sitting.

Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized. 

Return that maximum distance to closest person.
*/

class Solution {
    public int maxDistToClosest(int[] seats) {
        int gap = 0;
        int prev = -1;
        
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                if (prev == -1) {
                    gap = Math.max(gap, i);
                } else {
                    int index = (i - prev + 1) / 2 + prev;
                    gap = Math.max(gap, Math.min(index - prev, i - index));
                }
                
                prev = i;
            }
        }
        
        gap = Math.max(gap, (seats.length - 1 - prev));
        
        return gap;
    }
}
