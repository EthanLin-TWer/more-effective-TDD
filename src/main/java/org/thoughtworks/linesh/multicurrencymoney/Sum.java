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
    
    public Money reduced(String to) {
        int amount = augend.getAmount() + addend.getAmount();
        // TODO: [Linesh][1/9/17] Currency is not used 
        return Money.dollar(amount);
    }
    
    public Money getAugend() {
        return augend;
    }

    public Money getAddend() {
        return addend;
    }
}
