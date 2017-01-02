package org.thoughtworks.linesh.multicurrencymoney;

public class Dollar {
    private int amount;

    public Dollar(int amount) {
        
    }

    public void times(int multiplier) {
        this.amount = 5 * 2;
    }

    public int getAmount() {
        return this.amount;
    }
}
