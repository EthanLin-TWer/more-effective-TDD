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
        void should_test_france_multiplications() {
            Money five = Money.france(5);

            // It's actually a risk here that we rely on equality function for tests to work
            assertEquals(Money.france(10), five.times(2));
            assertEquals(Money.france(15), five.times(3));
        }
        
        @Tasking @Nested
        class should_test_equality {
            @Test
            void should_test_france_equality() {
                assertTrue(Money.france(5).equals(Money.france(5)));
                assertFalse(Money.france(5).equals(Money.france(6)));
            }
        }
    }
}
