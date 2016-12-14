package org.thoughtworks.linesh.fizzbuzzwhizz;

public class Student {
    public String say(int number, int firstSpecial) {
        return number % firstSpecial == 0 ? "Fizz" : "";
    }
}
