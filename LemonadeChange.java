/*
At a lemonade stand, each lemonade costs $5.
Customers are standing in a queue to buy from you, and order one at a time (in the order specified by bills).
Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill.  You must provide the correct change to each customer, so that the net transaction is that the customer pays $5.
Note that you don't have any change in hand at first.
Return true if and only if you can provide every customer with correct change.
*/
class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        if (bills.length == 0) return true;
        if (bills[0] != 5) return false;
        int fives = 0;
        int tens = 0;
        
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                fives++;
            } else if (bills[i] == 10) {
                if (fives == 0) return false;
                fives--;
                tens++;
            } else if (bills[i] == 20) {
                if (fives == 0) return false;
                if (tens > 0) {
                    tens--;
                    fives--;
                } else if (fives < 3) {
                    return false;
                } else {
                    fives -= 3;
                }
            }
        }
        
        return true;
    }
}
