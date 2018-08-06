/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

Example:

Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]
*/
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ips = new ArrayList<String>();
        if(s == null || s.length() < 4 || s.length() > 12) {
            return ips;
        }
        
        restoreIpAddresses(ips, s, 0, "", 0);
        
        return ips;
    }
    
    void restoreIpAddresses(List<String> ips, String s, int index, String ip, int dots) {
        
        if(dots == 4 && index == s.length()) {
            ips.add(ip.substring(0, ip.length()-1));
            return;
        } else if(dots >= 4) {
            return;
        }
        
        for(int i = 1; i < 4; i++) {
            if(index + i > s.length()) {
                break;
            }
            
            String subip = s.substring(index, index+i);
            
            if(Integer.parseInt(subip) >= 256 || (subip.charAt(0) == '0' && subip.length() > 1) || (dots == 3 && index+i != s.length())) {
                continue;
            }
            
            //ip += (subip + ".");
            restoreIpAddresses(ips, s, index + i, ip + subip + ".", dots + 1);
             
        }
    }
}
