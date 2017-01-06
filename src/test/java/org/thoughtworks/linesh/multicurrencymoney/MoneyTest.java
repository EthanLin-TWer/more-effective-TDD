package org.thoughtworks.linesh.multicurrencymoney;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {
    @Test
    void should_test_currency() {
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.france(1).currency());
    }
}