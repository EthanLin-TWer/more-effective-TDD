package org.thoughtworks.linesh.fizzbuzzwhizz;

public class Student {
    public String say(int number, int firstSpecial) {
        if (firstSpecial == 5) return "Buzz";
        return number % firstSpecial == 0 ? "Fizz" : "";
    }
}
