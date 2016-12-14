package org.thoughtworks.linesh.fizzbuzzwhizz;

public class Student {
    public String say(int number, int firstSpecial) {
        // TODO: [Linesh][12/14/16] should be able to pass in 2 special numbers
        // TODO: [Linesh][12/14/16] remove hardcoded 'second' special number 5
        if (number % this.secondSpecial == 0) return "Buzz";
        return number % this.firstSpecial == 0 ? "Fizz" : "";
    }

    public Student setFirstSpecial(int firstSpecial) {
        this.firstSpecial = firstSpecial;
        return this;
    }

    public Student setSecondSpecial(int secondSpecial) {
        this.secondSpecial = secondSpecial;
        return this;
    }

    private int firstSpecial;
    private int secondSpecial;
}
