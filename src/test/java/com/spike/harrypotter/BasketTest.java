package com.spike.harrypotter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BasketTest {

    private Basket basket;

    @Before
    public void setUp() throws Exception {
        basket = new Basket();
    }

    @Test
    public void emptyBasketCostsNothing() throws Exception {
        assertEquals(0L, basket.cost());
    }

    @Test
    public void oneBookCosts8Euros() throws Exception {
        basket.add(1, "Harry Potter I");

        assertEquals(800L, basket.cost());
    }
}
