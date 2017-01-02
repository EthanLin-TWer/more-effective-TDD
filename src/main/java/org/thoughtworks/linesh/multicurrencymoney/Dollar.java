package org.thoughtworks.linesh.multicurrencymoney;

public class Dollar {
    private int amount;

    public Dollar(int amount) {
        this.amount = amount;
    }

    public void times(int multiplier) {
        this.amount = this.amount * multiplier;
    }

    public int getAmount() {
        return this.amount;
    }
}
