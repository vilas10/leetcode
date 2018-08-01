/*
Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].
*/

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = IntStream.of(nums).boxed()
            .collect(Collectors.groupingBy(
                        Function.identity(), 
                        Collectors.summingInt(e -> 1)));
        
        Map<Integer, List<Integer>> freqMap = map.entrySet()
            .stream()
            .collect(Collectors.toMap(Map.Entry::getValue,
                                      e -> Arrays.asList(e.getKey()),
                                      (oldList, newList) -> Stream
                                        .concat(oldList.stream(), newList.stream())
                                        .collect(Collectors.toList())));
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, Collections.reverseOrder());
        pq.addAll(freqMap.keySet());
        
        List<Integer> result = new ArrayList<>();
        
        Integer val = null;
        while((val = pq.poll()) != null) {
            if (result.size() < k) result.addAll(freqMap.get(val)); else break;
        }
        
        return result;
    }
}
