package org.thoughtworks.linesh.multicurrencymoney;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import support.Tasking;

import static org.junit.jupiter.api.Assertions.*;

class DollarTest {
    @Tasking @Nested
    class should_test_multiplications {
        @Test
        void should_test_dollar_multiplications() {
            Money five = Money.dollar(5);

            // It's actually a risk here that we rely on equality function for tests to work
            assertEquals(Money.dollar(10), five.times(2));
            assertEquals(Money.dollar(15), five.times(3));
        }
        
        @Tasking @Nested
        class should_test_equality {
            @Test
            void should_test_dollar_equality() {
                assertTrue(Money.dollar(5).equals(Money.dollar(5)));
                assertFalse(Money.dollar(5).equals(Money.dollar(6)));
                assertFalse(Money.dollar(5).equals(null));
            }
        }
    }

    @Tasking
    @Nested
    class should_add_two_different_kinds_of_currency_given_exchange_rate {
        
    }

}
