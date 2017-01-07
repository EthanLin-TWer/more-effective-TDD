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
    
    @Tasking @Nested
    class should_test_equality {
        @Test
        void should_test_different_currency_equality() {
            assertFalse(Money.dollar(5).equals(Money.france(5)));
        }

        @Test
        void should_test_different_class_equality() {
            assertEquals(new Money(10, "CHF"), Money.france(10));
        }
    }
}