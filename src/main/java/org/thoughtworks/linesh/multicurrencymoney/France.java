package org.thoughtworks.linesh.multicurrencymoney;

// duplicated code of Dollar class and France class
public class France {
    private int amount;

    public France(int amount) {
        this.amount = amount;
    }

    public France times(int multiplier) {
        return new France(this.amount * multiplier);
    }

    public int getAmount() {
        // TODO: [Linesh][1/2/17] Currency amount as int?
        return this.amount;
    }

    // TODO: [Linesh][1/2/17] Implement equality check with null object
    // TODO: [Linesh][1/2/17] Implement equality check with different object type
    @Override
    public boolean equals(Object object) {
        France france = (France) object;
        return france.getAmount() == this.getAmount();
    }

    // TODO: [Linesh][1/2/17] Implement hashCode() method
}
