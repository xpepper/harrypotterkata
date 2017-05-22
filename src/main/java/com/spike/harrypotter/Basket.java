package com.spike.harrypotter;

import java.util.HashMap;
import java.util.Map;

public class Basket {
    public static final long PRICE_IN_CENTS = 800L;

    private Map<String, Integer> collection = new HashMap<>();

    public long cost() {
        long price = collection.getOrDefault("Harry Potter I", 0) * PRICE_IN_CENTS;
        return price;
    }

    public void add(int copies, String title) {
        collection.put(title, copies);
    }
}
