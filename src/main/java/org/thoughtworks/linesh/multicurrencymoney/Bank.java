package org.thoughtworks.linesh.multicurrencymoney;

public class Bank {
    public Money reduced(Expression money, String toCurrency) {
        Sum sum = (Sum) money;
        int amount = sum.getAddend().getAmount() + sum.getAugend().getAmount();
        return Money.dollar(amount);
    }
}
