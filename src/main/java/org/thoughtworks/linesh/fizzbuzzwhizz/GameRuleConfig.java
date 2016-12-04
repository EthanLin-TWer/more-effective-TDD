package org.thoughtworks.linesh.fizzbuzzwhizz;

public class GameRuleConfig {
    // TODO: [Linesh][12/3/16] Checkout REFACTOR to see how to migrate fields to another class
    private SpecialNumber specialNumbers = new SpecialNumber();
    private int thirdSpecialNumber;

    public void setFirstSpecialNumber(int firstSpecialNumber) {
        this.specialNumbers.setFirst(firstSpecialNumber);
    }

    public int getFirstSpecialNumber() {
        return this.specialNumbers.getFirst();
    }

    public void setSecondSpecialNumber(int secondSpecialNumber) {
        this.specialNumbers.setSecond(secondSpecialNumber);
    }

    public int getSecondSpecialNumber() {
        return this.specialNumbers.getSecond();
    }

    public void setThirdSpecialNumber(int thirdSpecialNumber) {
        this.thirdSpecialNumber = thirdSpecialNumber;
    }

    public int getThirdSpecialNumber() {
        return thirdSpecialNumber;
    }
}
