package org.thoughtworks.linesh.fizzbuzzwhizz;

public class Student {
    public String say(int number) {
        // TODO: [Linesh][12/14/16] 1. words("buzz", "fizz")
        if (number % this.secondSpecial == 0) return "Buzz";
        if (number % this.firstSpecial == 0) return "Fizz";
        if (number % this.thirdSpecial == 0) return "Whizz";
        return "";
    }

    public Student setFirstSpecial(int firstSpecial) {
        this.firstSpecial = firstSpecial;
        return this;
    }

    public Student setSecondSpecial(int secondSpecial) {
        this.secondSpecial = secondSpecial;
        return this;
    }

    public Student setThirdSpecial(int thirdSpecial) {
        this.thirdSpecial = thirdSpecial;
        return this;
    }

    private int firstSpecial;
    private int secondSpecial;
    private int thirdSpecial;
}
