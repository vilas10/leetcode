/*
A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

Each LED represents a zero or one, with the least significant bit on the right.
*/
public class BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<String>();
        
        if (num > 10 || num < 0) return result;
        
        for (int i=0; i < 4 && i <= num; i++) {
            int mins = num - i;
            if (mins >= 6) continue;
            
            result = possibleTimes(i, mins, result);
        }
        
        return result;
    }
    
    List<String> h0 = new ArrayList<String>(Arrays.asList("0"));
    List<String> h1 = new ArrayList<String>(Arrays.asList("1", "2", "4", "8"));
    List<String> h2 = new ArrayList<String>(Arrays.asList("3", "5", "6", "9", "10"));
    List<String> h3 = new ArrayList<String>(Arrays.asList("7", "11"));
    
    List<String> m0 = new ArrayList<String>(Arrays.asList("00"));
    List<String> m1 = new ArrayList<String>(Arrays.asList("01", "02", "04", "08", "16", "32"));
    List<String> m2 = new ArrayList<String>(Arrays.asList("03", "05", "09", "17", "33", "06", "10", "18", "34",
    "12", "20", "36", "24", "40", "48"));
    List<String> m3 = new ArrayList<String>(Arrays.asList("07", "11", "19", "35", "13", "21", "37", "25", "41", 
    "49", "14", "22", "38", "26", "42", "50", "28", "44", "52", "56"));
    List<String> m4 = new ArrayList<String>(Arrays.asList("15", "23", "39", "27", "43", "51", "29", "45", "57", "53", "30", "46", "54", "58"));
    List<String> m5 = new ArrayList<String>(Arrays.asList("31", "47", "55", "59"));
    
    
    List<List<String>> hours = new ArrayList<List<String>>(Arrays.asList(h0, h1, h2, h3));
    List<List<String>> minutes = new ArrayList<List<String>>(Arrays.asList(m0, m1, m2, m3, m4, m5));
    
    public List<String> possibleTimes(int h, int m, List<String> result) {
        List<String> hrs = hours.get(h);
        List<String> mins = minutes.get(m);
        
        for (int i=0; i<hrs.size(); i++) {
            for (int j=0; j<mins.size(); j++) {
                result.add(hrs.get(i) + ":" + mins.get(j));
            }
        }
        
        return result;
    }
}
