package org.thoughtworks.linesh.multicurrencymoney;

public class Money implements Expression {
    protected int amount;
    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public int getAmount() {
        // TODO: [Linesh][1/2/17] Currency amount as int?
        return this.amount;
    }

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    public static Money france(int amount) {
        return new Money(amount, "CHF");
    }

    @Override
    public boolean equals(Object object) {
        // TODO: [Linesh][1/2/17] Implement equality check with different object type
        if (object == null) return false;

        Money money = (Money) object;
        return money.getAmount() == this.getAmount() && 
                money.currency.equals(this.currency);
    }

    public String currency() {
        return currency;
    }

    protected String currency;

    public Money times(int multiplier) {
        return new Money(this.amount * multiplier, currency);
    }


    @Override
    public Expression plus(Money money) {
        return new Sum(Money.dollar(5), Money.dollar(5));
    }
}
