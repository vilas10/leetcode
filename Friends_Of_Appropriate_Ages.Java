/*
Some people will make friend requests. The list of their ages is given and ages[i] is the age of the ith person. 

Person A will NOT friend request person B (B != A) if any of the following conditions are true:

age[B] <= 0.5 * age[A] + 7
age[B] > age[A]
age[B] > 100 && age[A] < 100
Otherwise, A will friend request B.

Note that if A requests B, B does not necessarily request A.  Also, people will not friend request themselves.

How many total friend requests are made?

Example 1:

Input: [16,16]
Output: 2
Explanation: 2 people friend request each other.
Example 2:

Input: [16,17,18]
Output: 2
Explanation: Friend requests are made 17 -> 16, 18 -> 17.
Example 3:

Input: [20,30,100,110,120]
Output: 
Explanation: Friend requests are made 110 -> 100, 120 -> 110, 120 -> 100.
 

Notes:

1 <= ages.length <= 20000.
1 <= ages[i] <= 120.
*/
class Solution {
    public int numFriendRequests(int[] ages) {
        int requests = 0;
        
        int[] ageCounts = new int[121];
        for (int age: ages) ageCounts[age]++;
        
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < ages.length; i++) {
            if (set.contains(ages[i])) {
                continue;
            }
            
            int countB = 0;
            
            for (int j = 0; j < ages.length; j++) {                
                if (i != j && !friendRequest(ages[i], ages[j])) {
                    countB++;
                } 
            }
            
            requests += ageCounts[ages[i]] * countB;
            set.add(ages[i]);
        }
        
        return requests;
    }
    
    public boolean friendRequest(int A, int B) {
        return (B <= 0.5 * A + 7) || (B > A) || (B > 100 && A < 100);
    }
}
