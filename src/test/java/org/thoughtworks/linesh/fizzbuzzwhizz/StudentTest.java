package org.thoughtworks.linesh.fizzbuzzwhizz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentTest {

    private Student student;

    @BeforeEach
    void setUp() {
        student = new Student();
    }

    @Nested
    class SayFizzWhenNumberCanBeDividedByTheFirstSpecialNumber {

        private final int firstSpecial = 3;

        @Test
        void should_say_fizz_when_number_is_3() {
            String said = student.say(3, firstSpecial);

            assertEquals("Fizz", said);
        }

        @Test
        void should_say_fizz_when_number_is_6() {
            String said = student.say(6, firstSpecial);

            assertEquals("Fizz", said);
        }
    }

    @Nested
    class SayBuzzWhenNumberCanBeDividedByTheSecondSpecialNumber {

        private final int secondSpecial = 5;

        @Test
        void should_say_buzz_when_number_is_5() {
            String said = student.say(5, secondSpecial);

            assertEquals("Buzz", said);
        }
    }
}