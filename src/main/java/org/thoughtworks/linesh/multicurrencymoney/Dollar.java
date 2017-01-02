package org.thoughtworks.linesh.multicurrencymoney;

public class Dollar {
    private int amount;

    public Dollar(int amount) {
        this.amount = amount;
    }

    public Dollar times(int multiplier) {
        return new Dollar(this.amount * multiplier);
    }

    public int getAmount() {
        return this.amount;
    }
}
