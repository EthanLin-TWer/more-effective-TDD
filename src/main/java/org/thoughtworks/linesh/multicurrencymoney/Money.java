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

    @Override
    public boolean equals(Object object) {
        // TODO: [Linesh][1/4/17] Check *Refactor* about the steps to pull members up 
        // TODO: [Linesh][1/2/17] Implement equality check with different object type
        if (object == null) return false;
        
        Money money = (Money) object;
        return money.getAmount() == this.getAmount();
    }
}
