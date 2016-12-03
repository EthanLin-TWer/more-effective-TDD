package org.thoughtworks.linesh.fizzbuzzwhizz;

public class GameRuleConfig {
    // TODO: [Linesh][12/3/16] Checkout REFACTOR to see how to migrate fields to another class
    private int firstSpecialNumber;
    private int secondSpecialNumber;
    private SpecialNumber specialNumbers = new SpecialNumber();

    public void setFirstSpecialNumber(int firstSpecialNumber) {
        this.specialNumbers.setFirst(firstSpecialNumber);
    }

    public int getFirstSpecialNumber() {
        return this.specialNumbers.getFirst();
    }

    public void setSecondSpecialNumber(int secondSpecialNumber) {
        this.secondSpecialNumber = secondSpecialNumber;
    }

    public int getSecondSpecialNumber() {
        return secondSpecialNumber;
    }
}
