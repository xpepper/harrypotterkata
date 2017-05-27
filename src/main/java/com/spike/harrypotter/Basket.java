package com.spike.harrypotter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Basket {
    public static final long PRICE_IN_CENTS = 800L;
    private static final Map<Integer, Double> DISCOUNT_MAP = new HashMap<>();

    {
        DISCOUNT_MAP.put(1, 1.0);
        DISCOUNT_MAP.put(2, 0.95);
        DISCOUNT_MAP.put(3, 0.90);
        DISCOUNT_MAP.put(4, 0.80);
        DISCOUNT_MAP.put(5, 0.75);
    }

    private Map<String, Integer> collection = new HashMap<>();

    public long cost() {
        Integer copiesOfTheFirstBook = collection.getOrDefault("Harry Potter I", 0);
        Integer copiesOfTheSecondBook = collection.getOrDefault("Harry Potter II", 0);
        Integer copiesOfTheThirdBook = collection.getOrDefault("Harry Potter III", 0);
        Integer copiesOfTheFourthBook = collection.getOrDefault("Harry Potter IV", 0);
        Integer copiesOfTheFifthBook = collection.getOrDefault("Harry Potter V", 0);

        int[] copiesOfEachBook = new int[]{copiesOfTheFirstBook, copiesOfTheSecondBook, copiesOfTheThirdBook, copiesOfTheFourthBook, copiesOfTheFifthBook};
        List<Integer> bundleOfSeries = BookBundleFinder.findOn(copiesOfEachBook);

        long totalPrice = 0L;
        for (Integer series : bundleOfSeries) {
            double discount = DISCOUNT_MAP.get(series);
            totalPrice += series * discount * PRICE_IN_CENTS;
        }
        return totalPrice;
    }

    public void add(int copies, String title) {
        collection.put(title, copies);
    }
}
