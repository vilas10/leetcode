/*
Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.
*/

class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        int lowest = Integer.MAX_VALUE;
        List<String> result = new ArrayList<String>();
        
        for (int i=0; i< list1.length; i++) {
            map.put(list1[i], new Integer(i));
        }
        
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int sum = map.get(list2[i]) + i;
                if (lowest > sum) {
                    result = new ArrayList<String>();
                    result.add(list2[i]);
                    lowest = sum;
                } else if (lowest == sum) {
                    result.add(list2[i]);
                }
            }
        }
        
        return result.toArray(new String[result.size()]); 
    }
}
