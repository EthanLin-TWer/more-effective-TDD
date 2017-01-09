package org.thoughtworks.linesh.multicurrencymoney;

public class Sum implements Expression {
    private Money augend;
    private Money addend;

    public Sum(Money augend, Money addend) {
        this.augend = augend;
        this.addend = addend;
    }

    @Override
    public Expression plus(Money money) {
        return null;
    }

    public Money getAugend() {
        return augend;
    }

    public Money getAddend() {
        return addend;
    }
}
