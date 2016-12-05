package org.thoughtworks.linesh.fizzbuzzwhizz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import support.Tasking;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentTest {

    private Student student;
    private GameRuleConfig config;

    @BeforeEach
    void setUp() {
        config = new GameRuleConfig();
        config.setFirstSpecialNumber(3);
        config.setSecondSpecialNumber(5);
        config.setThirdSpecialNumber(7);

        student = new Student(config);
    }

    @Tasking @Nested
    class SayFizzWhenNumberCanBeDividedByTheFirstSpecialNumber {

        @Test
        void should_say_fizz_when_number_is_3() {
            String said = student.say(3);

            assertEquals("Fizz", said);
        }

        @Test
        void should_say_fizz_when_number_is_6() {
            String said = student.say(6);

            assertEquals("Fizz", said);
        }

        @Test
        void should_say_fizz_when_number_is_99() {
            String said = student.say(99);

            assertEquals("Fizz", said);
        }
    }

    @Tasking @Nested
    class SayBuzzWhenNumberCanBeDividedByTheSecondSpecialNumber {

        @Test
        // TODO: [Linesh][12/3/16] Naming: where should the 'given' info go? method name? @Nested class name? @DisplayName?
        void should_say_buzz_when_number_is_5() {
            String said = student.say(5);

            assertEquals("Buzz", said);
        }

        @Test
        void should_say_buzz_when_number_is_10() {
            String said = student.say(10);

            assertEquals("Buzz", said);
        }

        @Test
        void should_say_buzz_when_number_is_95() {
            String said = student.say(95);

            assertEquals("Buzz", said);
        }
    }

    @Tasking @Nested
    class SayWhizzWhenNumberCanBeDividedByTheThirdSpecialNumber {

        @Test
        void should_say_whizz_when_number_is_7() {
            String said = student.say(7);

            assertEquals("Whizz", said);
        }

        @Test
        void should_say_whizz_when_number_is_14() {
            String said = student.say(14);

            assertEquals("Whizz", said);
        }
    }

    @Tasking @Nested
    class SayFizzBuzzWhenNumberCanBeDividedByBothTheFirstAndSecondSpecialNumber {
        @Test
        void should_say_fizz_buzz_when_number_is_45() {
            String said = student.say(45);

            assertEquals("FizzBuzz", said);
        }

        @Test
        void should_say_fizz_buzz_when_number_is_60() {
            String said = student.say(60);

            assertEquals("FizzBuzz", said);
        }
    }

    @Tasking @Nested
    class SayBuzzWhizzWhenNumberCanBeDividedByBothTheSecondAndThirdSpecialNumber {
        @Test
        void should_say_buzz_whizz_when_number_is_70() {
            String said = student.say(70);

            assertEquals("BuzzWhizz", said);
        }
    }

    @Tasking @Nested
    class SayFizzWhizzWhenNumberCanBeDividedByBothTheFirstAndThirdSpecialNumber {
        @Test
        void should_say_fizz_whizz_when_number_is_21() {
            String said = student.say(21);

            assertEquals("FizzWhizz", said);
        }

        @Test
        void should_say_fizz_whizz_when_number_is_84() {
            String said = student.say(84);

            assertEquals("FizzWhizz", said);
        }
    }

    @Tasking @Nested
    class SayFizzBuzzWhizzWhenNumberCanBeDividedByAllTheThreeNumbers {

        @Test
        void should_say_fizz_buzz_when_number_is_105() {
            String said = student.say(105);

            assertEquals("FizzBuzzWhizz", said);
        }
    }

    @Tasking @Nested
    class SayFizzWhenNumberContainsTheFirstSpecialNumberRegardlessAllRulesAbove {
        @Test
        void should_say_fizz_when_number_is_13_that_contains_special_number_3() {
            String said = student.say(13);

            assertEquals("Fizz", said);
        }

        @Test
        void should_say_fizz_when_number_is_33_that_can_be_divided_by_3() {
            String said = student.say(33);

            assertEquals("Fizz", said);
        }

        @Test
        void should_say_fizz_when_number_is_35_that_can_be_divided_by_5_and_7() {
            String said = student.say(35);

            assertEquals("Fizz", said);
        }
    }

    @Tasking @Nested
    class SayOriginNumberWhenNumberDoesNotSatisfiedAllRulesAbove {
        @Test
        void should_say_0_when_number_is_0() {
            String said = student.say(0);

            assertEquals("0", said);
        }
    }
}