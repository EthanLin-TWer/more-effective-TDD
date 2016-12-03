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
        private Student student;

        @BeforeEach
        void setUp() {
            student = new Student();
        }

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
}