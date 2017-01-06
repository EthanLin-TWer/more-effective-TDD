package org.thoughtworks.linesh.multicurrencymoney;

public class Dollar extends Money {

    Dollar(int amount) {
        super(amount);
        currency = "USD";
    }

    public Money times(int multiplier) {
        return new Dollar(this.amount * multiplier);
    }
    
    // TODO: [Linesh][1/2/17] Implement hashCode() method
}
