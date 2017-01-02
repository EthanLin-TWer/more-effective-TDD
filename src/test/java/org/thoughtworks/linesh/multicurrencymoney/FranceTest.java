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
        void should_get_10_dollars_when_multiple_2_with_5() {
            France five = new France(5);

            // It's actually a risk here that we rely on equality function for tests to work
            assertEquals(new France(10), five.times(2));
        }

        @Test
        void should_get_15_dollars_when_multiple_3_with_5() {
            France five = new France(5);

            assertEquals(new France(15), five.times(3));
        }

        @Tasking @Nested
        class should_test_equality {
            @Test
            void should_5_dollars_equals_to_5_dollars() {
                assertTrue(new France(5).equals(new France(5)));
            }

            @Test
            void should_5_dollars_not_equals_to_6_dollars() {
                assertFalse(new France(5).equals(new France(6)));
            }
        }
    }
}
