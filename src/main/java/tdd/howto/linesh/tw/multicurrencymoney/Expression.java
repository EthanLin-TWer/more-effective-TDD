package tdd.howto.linesh.tw.multicurrencymoney;

public interface Expression {
    Expression plus(Money money);

    Money reduce(String currency);
}
