/*
A website domain like "discuss.leetcode.com" consists of various subdomains. At the top level, we have "com", at the next level, we have "leetcode.com", and at the lowest level, "discuss.leetcode.com". When we visit a domain like "discuss.leetcode.com", we will also visit the parent domains "leetcode.com" and "com" implicitly.

Now, call a "count-paired domain" to be a count (representing the number of visits this domain received), followed by a space, followed by the address. An example of a count-paired domain might be "9001 discuss.leetcode.com".

We are given a list cpdomains of count-paired domains. We would like a list of count-paired domains, (in the same format as the input, and in any order), that explicitly counts the number of visits to each subdomain.
*/

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for (int i = 0; i < cpdomains.length; i++) {
            String[] split = cpdomains[i].split(" ");
            int count = Integer.parseInt(split[0]);
            
            if (map.containsKey(split[1])) {
                map.put(split[1], map.get(split[1]) + count); 
            } else {
                map.put(split[1], count); 
            }
            
            String[] dot1 = split[1].split("\\.", 2);
            if (map.containsKey(dot1[1])) {
                map.put(dot1[1], map.get(dot1[1]) + count); 
            } else {
                map.put(dot1[1], count); 
            }
            
            if (dot1[1].contains(".")) {
                String[] dot2 = dot1[1].split("\\.", 2);
                
                if (map.containsKey(dot2[1])) {
                    map.put(dot2[1], map.get(dot2[1]) + count); 
                } else {
                    map.put(dot2[1], count); 
                }
            }
        }
        
        List<String> result = new ArrayList<String>();
        
        for (String key: map.keySet()) {
            String s = map.get(key) + " " + key;
            result.add(s);
        }
        
        return result;
    }
}
