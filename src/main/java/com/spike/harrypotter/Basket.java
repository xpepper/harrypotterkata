package com.spike.harrypotter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.LongStream;

import static com.spike.harrypotter.BookBundleFinder.findAllAvailableBundlesIn;

public class Basket {
    private static final long PRICE_IN_CENTS = 800L;
    private static final Map<Integer, Double> DISCOUNT_MAP = new HashMap<>();

    {
        DISCOUNT_MAP.put(1, 1.0);
        DISCOUNT_MAP.put(2, 0.95);
        DISCOUNT_MAP.put(3, 0.90);
        DISCOUNT_MAP.put(4, 0.80);
        DISCOUNT_MAP.put(5, 0.75);
    }

    private Map<String, Integer> bookCollection = new HashMap<>();

    public void add(int copies, String title) {
        bookCollection.put(title, copies);
    }

    public long cost() {
        Integer copiesOfTheFirstBook = bookCollection.getOrDefault("Harry Potter I", 0);
        Integer copiesOfTheSecondBook = bookCollection.getOrDefault("Harry Potter II", 0);
        Integer copiesOfTheThirdBook = bookCollection.getOrDefault("Harry Potter III", 0);
        Integer copiesOfTheFourthBook = bookCollection.getOrDefault("Harry Potter IV", 0);
        Integer copiesOfTheFifthBook = bookCollection.getOrDefault("Harry Potter V", 0);

        int[] copiesOfEachBook = new int[]{copiesOfTheFirstBook, copiesOfTheSecondBook, copiesOfTheThirdBook, copiesOfTheFourthBook, copiesOfTheFifthBook};
        List<List<Integer>> allAvailableBundles = findAllAvailableBundlesIn(copiesOfEachBook);
        return bestPriceFrom(allAvailableBundles);
    }

    private long bestPriceFrom(List<List<Integer>> bundles) {
        LongStream prices = bundles.stream().mapToLong(b -> price(b));
        return prices.min().orElse(0);
    }

    private long price(List<Integer> bundleOfSeries) {
        long totalPrice = 0L;
        for (Integer series : bundleOfSeries) {
            totalPrice += price(series) * PRICE_IN_CENTS;
        }
        return totalPrice;
    }

    private double price(Integer series) {
        Double discountPercentage = DISCOUNT_MAP.get(series);
        return series * discountPercentage;
    }
}
