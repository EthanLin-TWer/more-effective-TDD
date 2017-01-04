package org.thoughtworks.linesh.multicurrencymoney;

public class Dollar {

    protected int amount;

    public Dollar(int amount) {
        this.amount = amount;
    }

    public Dollar times(int multiplier) {
        return new Dollar(this.amount * multiplier);
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
        
        Dollar money = (Dollar) object;
        return money.getAmount() == this.getAmount();
    }

    // TODO: [Linesh][1/2/17] Implement hashCode() method
}
