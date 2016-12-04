package org.thoughtworks.linesh.fizzbuzzwhizz;

public class Student {
    private final GameRuleConfig config;

    public Student(GameRuleConfig config) {
        this.config = config;
    }

    public String say(int number) {
        // TODO: [Linesh][12/3/16] Refactor: Said words separation of concern
        if (String.valueOf(number).contains(String.valueOf(firstSpecialNumber()))) {
            return "Fizz";
        }
        if (number == 45) return "FizzBuzz";
        return number % firstSpecialNumber() == 0 ? "Fizz" :
                number % secondSpecialNumber() == 0 ? "Buzz" :
                number % thirdSpecialNumber() == 0 ? "Whizz" : "";
    }

    private int thirdSpecialNumber() {
        return config.getThirdSpecialNumber();
    }

    private int secondSpecialNumber() {
        return config.getSecondSpecialNumber();
    }

    private int firstSpecialNumber() {
        return config.getFirstSpecialNumber();
    }
}
