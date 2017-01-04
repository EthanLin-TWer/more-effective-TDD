package org.thoughtworks.linesh.multicurrencymoney;

// duplicated code of Dollar class and France class
public class France extends Money{
    public France(int amount) {
        super(amount);
    }

    public int getAmount() {
        return this.amount;
    }

    public France times(int multiplier) {
        return new France(this.amount * multiplier);
    }

    @Override
    public boolean equals(Object object) {
        // TODO: [Linesh][1/4/17] Check *Refactor* about the steps to pull members up 
        // TODO: [Linesh][1/2/17] Implement equality check with different object type
        if (object == null) return false;

        France france = (France) object;
        return france.getAmount() == this.getAmount();
    }

    // TODO: [Linesh][1/2/17] Implement hashCode() method
}
