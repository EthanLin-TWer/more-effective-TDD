package org.thoughtworks.linesh.fizzbuzzwhizz;

public class Student {
    public String say(int number, int firstSpecial) {
        // TODO: [Linesh][12/14/16] should be able to pass in 2 special numbers
        // TODO: [Linesh][12/14/16] remvoe hardcoded 'second' special number 5
        if (firstSpecial == 5) return "Buzz";
        return number % firstSpecial == 0 ? "Fizz" : "";
    }
}
