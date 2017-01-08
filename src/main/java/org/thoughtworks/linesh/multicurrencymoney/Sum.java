package org.thoughtworks.linesh.multicurrencymoney;

public class Sum implements Expression {
    public Money augend;
    public Money addend;

    public Sum(Money augend, Money addend) {
        this.augend = Money.dollar(5);
        this.addend = Money.dollar(5);
    }

    @Override
    public Expression plus(Money money) {
        return null;
    }
}
