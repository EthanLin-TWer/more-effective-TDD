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
        // TODO: [Linesh][1/2/17] Currency amount as int?
        return this.amount;
    }

    // TODO: [Linesh][1/2/17] Implement equality check with different object type
    @Override
    public boolean equals(Object object) {
        if (object == null) return false;
        Dollar dollar = (Dollar) object;
        return dollar.getAmount() == this.getAmount();
    }

    // TODO: [Linesh][1/2/17] Implement hashCode() method
}
