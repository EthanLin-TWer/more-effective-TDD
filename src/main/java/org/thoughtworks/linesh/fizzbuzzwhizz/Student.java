package org.thoughtworks.linesh.fizzbuzzwhizz;

public class Student {
    private final GameRuleConfig config;
    // TODO: [Linesh][12/3/16] firstSpecial should not be here

    public Student(GameRuleConfig config) {
        this.config = config;
    }

    public String say(int number) {
        // TODO: [Linesh][12/3/16] Refactor
        return number % firstSpecial() == 0 ? "Fizz" :
                number % secondSpecial() == 0 ? "Buzz" :
                number % thirdSpecial() == 0 ? "Whizz" : "";
    }

    private int thirdSpecial() {
        return config.getThirdSpecialNumber();
    }

    private int secondSpecial() {
        return config.getSecondSpecialNumber();
    }

    private int firstSpecial() {
        return config.getFirstSpecialNumber();
    }
}
