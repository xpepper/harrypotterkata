package com.spike.harrypotter;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class BasketTest {

    private Basket basket;

    @Before
    public void setUp() throws Exception {
        basket = new Basket();
    }

    @Test
    public void empty_basket_costs_nothing() throws Exception {
        assertEquals(0L, new Basket().cost());
    }

    @Test
    public void one_book_costs_8_euros() throws Exception {
        basket.add(1, "Harry Potter I");

        assertEquals(800L, basket.cost());
    }

    @Test
    public void more_copies_of_the_same_book_got_no_discount() throws Exception {
        basket.add(4, "Harry Potter I");

        assertEquals(4 * 800L, basket.cost());
    }

    @Test
    public void any_single_book_of_the_series_costs_8_euros() throws Exception {
        List<String> numbers = asList("I", "II", "III", "IV", "V");
        numbers.stream().forEach((n) -> {
            Basket b = basketWithOneBookOfSeries(n);
            assertEquals(800L, b.cost());
        });
    }

    private Basket basketWithOneBookOfSeries(String series) {
        Basket basket = new Basket();
        basket.add(1, "Harry Potter " + series);
        return basket;
    }
}
