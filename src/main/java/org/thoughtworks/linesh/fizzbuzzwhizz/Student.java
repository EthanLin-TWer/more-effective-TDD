package org.thoughtworks.linesh.fizzbuzzwhizz;

public class Student {
    private final GameRuleConfig config;

    public Student(GameRuleConfig config) {
        this.config = config;
    }

    public String say(int number) {
        // TODO: [Linesh][12/3/16] Refactor: Said words separation of concern
        // TODO: [Linesh][12/4/16] 这两种不同规则有"规则"的概念，如何体现并分离？
        if (String.valueOf(number).contains(String.valueOf(firstSpecialNumber()))) {
            return "Fizz";
        }

        String result = "";
            // TODO: [Linesh][12/4/16] 这里出现了"组合"的概念，现在它被 hardcode 在此处，看看有无组合相关的设计模式，可以分离这个关注点
        if (number % firstSpecialNumber() == 0) result += "Fizz";
        if (number % secondSpecialNumber() == 0) result += "Buzz";

        return number % firstSpecialNumber() == 0 ? result :
                number % secondSpecialNumber() == 0 ? result :
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
