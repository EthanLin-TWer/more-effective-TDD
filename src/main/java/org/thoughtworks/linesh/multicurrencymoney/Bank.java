package org.thoughtworks.linesh.multicurrencymoney;

public class Bank {
    public Money reduced(Expression money, String toCurrency) {
        // TODO: [Linesh][1/9/17] Is type cast a bad smell? 
        if (money instanceof Money) return (Money) money;
        Sum sum = (Sum) money;
        return sum.reduced(toCurrency);
    }
}
