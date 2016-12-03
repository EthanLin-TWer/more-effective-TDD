package org.thoughtworks.linesh.fizzbuzzwhizz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentTest {
    @BeforeEach
    void setUp() {

    }

    @Nested
    class SayFizzWhenNumberContainsTheFirstSpecialNumber {

        private final int firstSpecial = 3;

        @Test
        void should_say_fizz_when_number_is_3() {
            Student student = new Student();

            String said = student.say(3, firstSpecial);

            assertEquals("Fizz", said);
        }
    }
}