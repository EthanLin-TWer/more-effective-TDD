package org.thoughtworks.linesh.multicurrencymoney;

public class Bank {
    public Money reduced(Expression money, String toCurrency) {
        return money.reduce(toCurrency);
    }
}
