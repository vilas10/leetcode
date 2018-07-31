/*
A robot on an infinite grid starts at point (0, 0) and faces north.  The robot can receive one of three possible types of commands:

-2: turn left 90 degrees
-1: turn right 90 degrees
1 <= x <= 9: move forward x units
Some of the grid squares are obstacles. 

The i-th obstacle is at grid point (obstacles[i][0], obstacles[i][1])

If the robot would try to move onto them, the robot stays on the previous grid square instead (but still continues following the rest of the route.)

Return the square of the maximum Euclidean distance that the robot will be from the origin.
*/
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] pos = new int[2];
        int dir = 0;
        
        Set<String> obs = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            obs.add("(" + obstacles[i][0] + "," + obstacles[i][1] + ")");
        }
        
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < commands.length; i++) {
            switch(commands[i]) {
                case -2 : 
                    dir = (dir + 1) % 4;
                    break;
                case -1 : 
                    dir = (dir + 3) % 4;
                    break;
                default:
                    int moves = commands[i];
                    if (moves >= 1 && moves <= 9) {
                    while (moves > 0) {
                        if (dir == 0) {
                            if (obs.contains("(" + (pos[0]) + "," + (pos[1] + 1) + ")")) break;
                            pos[1]++;
                        }
                        if (dir == 1) {
                            if (obs.contains("(" + (pos[0] - 1) + "," + (pos[1]) + ")")) break;
                            pos[0]--;
                        }
                        if (dir == 2) {
                            if (obs.contains("(" + (pos[0]) + "," + (pos[1] - 1) + ")")) break;
                            pos[1]--;
                        }
                        if (dir == 3) {
                            if (obs.contains("(" + (pos[0] + 1) + "," + (pos[1]) + ")")) break;
                            pos[0]++;
                        }
                        moves--;
                    }
                        max = Math.max(pos[0] * pos[0] + pos[1] * pos[1], max);
                    }
            }
        }
        
        return max;
    }
}
