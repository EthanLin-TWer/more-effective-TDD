package org.thoughtworks.linesh.multicurrencymoney;

public abstract class Money {
    protected int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        // TODO: [Linesh][1/2/17] Currency amount as int?
        return this.amount;
    }
    
    abstract Money times(int multiplier);
    
    @Override
    public boolean equals(Object object) {
        // TODO: [Linesh][1/2/17] Implement equality check with different object type
        if (object == null) return false;
        if (this.getClass() != object.getClass()) return false;
        
        Money money = (Money) object;
        return money.getAmount() == this.getAmount();
    }

    public static Money dollar(int amount) {
        return new Dollar(amount);
    }

    public static Money france(int amount) {
        return new France(amount);
    }
}
