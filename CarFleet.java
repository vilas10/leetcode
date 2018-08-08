/*
N cars are going to the same destination along a one lane road.  The destination is target miles away.

Each car i has a constant speed speed[i] (in miles per hour), and initial position position[i] miles towards the target along the road.

A car can never pass another car ahead of it, but it can catch up to it, and drive bumper to bumper at the same speed.

The distance between these two cars is ignored - they are assumed to have the same position.

A car fleet is some non-empty set of cars driving at the same position and same speed.  Note that a single car is also a car fleet.

If a car catches up to a car fleet right at the destination point, it will still be considered as one car fleet.


How many car fleets will arrive at the destination?

 

Example 1:

Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
Output: 3
Explanation:
The cars starting at 10 and 8 become a fleet, meeting each other at 12.
The car starting at 0 doesn't catch up to any other car, so it is a fleet by itself.
The cars starting at 5 and 3 become a fleet, meeting each other at 6.
Note that no other cars meet these fleets before the destination, so the answer is 3.

Note:

0 <= N <= 10 ^ 4
0 < target <= 10 ^ 6
0 < speed[i] <= 10 ^ 6
0 <= position[i] < target
All initial positions are different.
*/
class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        ArrayList list = new ArrayList<CarTime>();
        for(int i=0; i<position.length; i++){
            list.add(new CarTime(target, position[i], speed[i]));
        }
        
        Collections.sort(list, new CarTimeComparator());
        int fleet = 0;
        
        while (list.size() > 0) {
            double ltime = ((double) target - ((CarTime)list.get(0)).getPos()) / ((CarTime)list.get(0)).getSpeed();
            int i = 1;
            for ( ;i < list.size(); i++) {
                double time = ((double) target - ((CarTime)list.get(i)).getPos()) / ((CarTime)list.get(i)).getSpeed();
                if (ltime >= time) continue;
                else break;
            } 
            
            for (int j = i - 1 ; j >= 0; j--) {
                list.remove(j);
            }
            fleet++;
        }
        
        return fleet;
    }
}

class CarTime {
    private int target;
    private int pos;
    private int speed;
    
    public CarTime(int t, int p, int s) {
        this.target = t;
        this.pos = p;
        this.speed = s;
    }
    
    public int getTarget() {
        return this.target;
    }
    
    public int getPos() {
        return this.pos;
    }
    
    public int getSpeed() {
        return this.speed;
    }
    
    @Override
    public String toString() {
        return target + "," + pos + "," + speed;
    }
}

class CarTimeComparator implements Comparator<CarTime> {
    @Override
    public int compare(CarTime c1, CarTime c2) {
        //return Double.compare(((double)(c1.getTarget() - c1.getPos())) / c1.getSpeed(), ((double)(c2.getTarget() - c2.getPos())) / c2.getSpeed());
        return Integer.compare(c2.getPos(), c1.getPos());
    }
}
