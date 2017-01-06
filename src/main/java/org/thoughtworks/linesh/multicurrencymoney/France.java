package org.thoughtworks.linesh.multicurrencymoney;

// duplicated code of Dollar class and France class
public class France extends Money{

    France(int amount, String currency) {
        super(amount, currency);
    }
    
    public Money times(int multiplier) {
        return Money.france(this.amount * multiplier);
    }

    // TODO: [Linesh][1/2/17] Implement hashCode() method
}
