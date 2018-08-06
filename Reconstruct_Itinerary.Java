/*
Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:

If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
Example 1:

Input: tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
Example 2:

Input: tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
*/
public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> itinerary = new LinkedList<String>();
        if(tickets == null || tickets.length == 0) {
            return itinerary;
        }
        
        Map<String, PriorityQueue<String>> tos = new HashMap<>();
        for(String[] from: tickets) {
            
            PriorityQueue<String> dests = tos.get(from[0]);
            if(dests == null) {
                PriorityQueue<String> temp = new PriorityQueue<String>();
                temp.add(from[1]);
                tos.put(from[0], temp);
            } else {
                dests.add(from[1]);
                tos.put(from[0], dests);
            }
            //tos.computeIfAbsent(from[0], k -> new PriorityQueue()).add(from[1]);
        }
        
        Stack<String> st = new Stack<String>();
        st.push("JFK");
        
        while(!st.isEmpty()) {
            String from = st.peek();
            while (tos.containsKey(from) && !tos.get(from).isEmpty()) {
                st.push(tos.get(from).poll());
                from = st.peek();
            } 
            
            itinerary.add(0, st.pop());
        }
        
        return itinerary;
    }
}
