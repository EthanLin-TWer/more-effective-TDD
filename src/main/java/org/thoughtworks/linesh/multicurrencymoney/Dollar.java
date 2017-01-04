package org.thoughtworks.linesh.multicurrencymoney;

public class Dollar extends Money {

    public Dollar(int amount) {
        super(amount);
    }

    public Dollar times(int multiplier) {
        return new Dollar(this.amount * multiplier);
    }

    // TODO: [Linesh][1/2/17] Implement hashCode() method
}
