package org.thoughtworks.linesh.multicurrencymoney;

// duplicated code of Dollar class and France class
public class France extends Money{

    France(int amount) {
        super(amount);
        currency = "CHF";
    }
    
    public Money times(int multiplier) {
        return new France(this.amount * multiplier);
    }

    // TODO: [Linesh][1/2/17] Implement hashCode() method
}
