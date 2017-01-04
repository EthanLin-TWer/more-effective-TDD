package org.thoughtworks.linesh.multicurrencymoney;

public class Money {
    protected int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        // TODO: [Linesh][1/2/17] Currency amount as int?
        return this.amount;
    }
}
