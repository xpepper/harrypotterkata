package com.spike.harrypotter;

import java.util.*;

import static java.util.Arrays.stream;

public class BookBundleFinder {

    public static final int SERIES_SIZE = 5;

    public static List<List<Integer>> findAllAvailableBundlesIn(int[] copiesPerEpisode) {
        List<List<Integer>> availableBundles = new ArrayList<>();
        for (int bundleSize = SERIES_SIZE; bundleSize >= SERIES_SIZE-1; bundleSize--) {
            List<Integer> bundles = bundlesOfMaxSize(copiesPerEpisode, bundleSize);
            if (bundles.isEmpty() || availableBundles.contains(bundles))
                break;
            availableBundles.add(bundles);
        }
        return availableBundles;
    }

    private static List<Integer> bundlesOfMaxSize(int[] copiesPerEpisode, int bundleMaximumSize) {
        List<Integer> bundles = new ArrayList<>();
        int[] copies = Arrays.copyOf(copiesPerEpisode, copiesPerEpisode.length);
        while (hasMoreBooks(copies) > 0) {
            int bundleSize = 0;
            for (int i = 0; i < SERIES_SIZE; i++) {
                if (copies[i] <= 0)
                    continue;
                copies[i]--;
                bundleSize++;
                if (bundleSize >= bundleMaximumSize)
                    break;
            }
            bundles.add(bundleSize);
        }
        return bundles;
    }

    private static int hasMoreBooks(int[] copiesPerEpisode) {
        return stream(copiesPerEpisode).sum();
    }
}
