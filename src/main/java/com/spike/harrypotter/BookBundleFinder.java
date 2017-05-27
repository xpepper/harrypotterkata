package com.spike.harrypotter;

import java.util.*;

import static java.util.Arrays.stream;

public class BookBundleFinder {

    public static final int SERIES_SIZE = 5;

    public static List<Integer> findOn(int[] copiesPerEpisode) {
        List<Integer> bundles = new ArrayList<>();
        while (stream(copiesPerEpisode).sum() > 0) {
            int bundleSize = 0;
            for (int i = 0; i < SERIES_SIZE; i++) {
                if (copiesPerEpisode[i] <= 0)
                    continue;
                copiesPerEpisode[i]--;
                bundleSize++;
            }
            bundles.add(bundleSize);
        }
        return bundles;
    }
}
