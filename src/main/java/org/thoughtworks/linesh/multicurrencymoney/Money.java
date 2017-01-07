package org.thoughtworks.linesh.multicurrencymoney;

public class Money {
    protected int amount;
    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public int getAmount() {
        // TODO: [Linesh][1/2/17] Currency amount as int?
        return this.amount;
    }

    public Money times(int multiplier) {
        return null;
    }

    public static Money dollar(int amount) {
        return new Dollar(amount, "USD");
    }

    public static Money france(int amount) {
        return new France(amount, "CHF");
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
}
