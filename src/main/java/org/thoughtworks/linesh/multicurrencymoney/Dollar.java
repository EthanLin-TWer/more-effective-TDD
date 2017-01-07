package org.thoughtworks.linesh.multicurrencymoney;

public class Dollar extends Money {

    Dollar(int amount, String currency) {
        super(amount, currency);
    }

    public Money times(int multiplier) {
        return new Money(this.amount * multiplier, currency);
    }
    
    // TODO: [Linesh][1/2/17] Implement hashCode() method
}
