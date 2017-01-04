package org.thoughtworks.linesh.multicurrencymoney;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import support.Tasking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FranceTest {
    @Tasking
    @Nested
    class should_test_multiplications {
        @Test
        void should_get_10_frances_when_multiple_2_with_5() {
            Money five = Money.france(5);

            // It's actually a risk here that we rely on equality function for tests to work
            assertEquals(Money.france(10), five.times(2));
        }

        @Test
        void should_get_15_frances_when_multiple_3_with_5() {
            Money five = Money.france(5);

            assertEquals(Money.france(15), five.times(3));
        }

        @Tasking @Nested
        class should_test_equality {
            @Test
            void should_5_frances_equals_to_5_frances() {
                assertTrue(Money.france(5).equals(Money.france(5)));
            }

            @Test
            void should_5_frances_not_equals_to_6_frances() {
                assertFalse(Money.france(5).equals(Money.france(6)));
            }
        }
    }
}
