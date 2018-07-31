/*
There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room may have some keys to access the next room. 

Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.

Initially, all the rooms start locked (except for room 0). 

You can walk back and forth between rooms freely.

Return true if and only if you can enter every room.
*/

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int total = rooms.size();
        boolean[] doors = new boolean[total];
        Stack<Integer> stack = new Stack<>();
        
        List<Integer> room0Keys = rooms.get(0);
        doors[0] = true;
        for (Integer key: room0Keys) {
            stack.push(key);
        }
        
        while (!stack.empty()) {
            int nextroom = stack.pop();
            
            if (!doors[nextroom]) {
                doors[nextroom] = true;
                
                List<Integer> keys = rooms.get(nextroom);
                for (Integer key: keys) {
                    stack.push(key);
                }
            }
        }
        
        for (int i = 1; i < doors.length; i++) {
            if (!doors[i]) {
                return false;
            }
        }
        
        return true;
    }
}
