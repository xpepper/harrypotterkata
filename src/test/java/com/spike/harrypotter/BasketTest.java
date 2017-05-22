package com.spike.harrypotter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BasketTest {
    @Test
    public void emptyBasketCostsNothing() throws Exception {
        Basket basket = new Basket();
        Long priceInCent = basket.cost();
        assertEquals(0L, priceInCent.longValue());
    }
}
