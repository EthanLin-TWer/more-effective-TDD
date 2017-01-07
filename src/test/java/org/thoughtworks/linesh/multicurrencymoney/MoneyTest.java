package org.thoughtworks.linesh.multicurrencymoney;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import support.Tasking;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {
    @Test
    void should_test_currency() {
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.france(1).currency());
    }

    @Test
    void should_test_multiplications() {
        Money fiveDollars = Money.dollar(5);
        Money fiveFrances = Money.france(5);

        // TODO: [Linesh][1/7/17] Is it a risk here that we rely on equality function for tests to work
        assertEquals(Money.dollar(10), fiveDollars.times(2));
        assertEquals(Money.dollar(15), fiveDollars.times(3));
        assertEquals(Money.france(10), fiveFrances.times(2));
        assertEquals(Money.france(15), fiveFrances.times(3));
    }

    @Tasking @Nested
    class should_test_equality {

        @Test
        void should_test_same_currency_equality() {
            assertTrue(Money.dollar(5).equals(Money.dollar(5)));
            assertFalse(Money.dollar(5).equals(Money.dollar(6)));
            assertFalse(Money.dollar(5).equals(null));
        }

        @Test
        void should_test_different_currency_equality() {
            assertFalse(Money.dollar(5).equals(Money.france(5)));
        }

        @Test
        void should_test_different_class_equality() {
            assertEquals(new Money(10, "CHF"), Money.france(10));
        }
    }

    @Tasking
    @Nested
    class should_add_two_different_kinds_of_currency_given_exchange_rate {

    }
}