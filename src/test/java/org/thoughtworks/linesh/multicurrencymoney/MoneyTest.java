package org.thoughtworks.linesh.multicurrencymoney;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import support.Tasking;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {
    @Tasking
    @Nested
    class should_multiple_shares_with_price_and_get_total {
        @Test
        void should_get_10_dollars_when_multiple_2_with_5() {
            Dollar five = new Dollar(5);
            // TODO: [Linesh][1/2/17] Side effect of times method?
            five.times(2);
            // TODO: [Linesh][1/2/17] Currency amount as int?
            // TODO: [Linesh][1/2/17] 'amount' should not be accessed directly, should be private 
            assertEquals(10, five.amount);
        }
    }

    @Tasking
    @Nested
    class should_add_two_different_kinds_of_currency_given_exchange_rate {
        
    }

}
