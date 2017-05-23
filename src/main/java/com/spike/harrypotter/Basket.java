package com.spike.harrypotter;

import java.util.HashMap;
import java.util.Map;

public class Basket {
    public static final long PRICE_IN_CENTS = 800L;

    private Map<String, Integer> collection = new HashMap<>();

    public long cost() {
        Integer first = collection.getOrDefault("Harry Potter I", 0);
        Integer second = collection.getOrDefault("Harry Potter II", 0);
        Integer third = collection.getOrDefault("Harry Potter III", 0);
        Integer fourth = collection.getOrDefault("Harry Potter IV", 0);
        Integer fifth = collection.getOrDefault("Harry Potter V", 0);
        return (first + second + third + fourth + fifth) * PRICE_IN_CENTS;
    }

    public void add(int copies, String title) {
        collection.put(title, copies);
    }
}
