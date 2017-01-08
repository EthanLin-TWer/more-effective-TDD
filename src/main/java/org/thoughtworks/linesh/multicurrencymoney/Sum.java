package org.thoughtworks.linesh.multicurrencymoney;

public class Sum implements Expression {
    public Money augend;
    public Money addend;

    public Sum(Money augend, Money addend) {
        this.augend = augend;
        this.addend = addend;
    }

    @Override
    public Expression plus(Money money) {
        return null;
    }
}
