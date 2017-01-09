package org.thoughtworks.linesh.multicurrencymoney;

public class Bank {
    public Money reduced(Expression money, String toCurrency) {
        // TODO: [Linesh][1/9/17] Type cast is a bad smell? 
        Sum sum = (Sum) money;
        // TODO: [Linesh][1/9/17] Second chained call
        int amount = sum.getAddend().getAmount() + sum.getAugend().getAmount();
        // TODO: [Linesh][1/9/17] Currency is not used 
        return Money.dollar(amount);
    }
}
