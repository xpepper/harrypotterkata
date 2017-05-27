package com.spike.harrypotter;

import org.junit.Test;

import java.util.List;

import static com.spike.harrypotter.BookBundleFinder.findAllAvailableBundlesIn;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class BookBundleFinderTest {
    @Test
    public void no_bundles_when_there_are_no_copies() throws Exception {
        List<List<Integer>> allAvailableBundles = findAllAvailableBundlesIn(new int[]{0, 0, 0, 0, 0});

        assertTrue(allAvailableBundles.isEmpty());
    }

    @Test
    public void just_one_bundle() throws Exception {
        List<List<Integer>> allAvailableBundles = findAllAvailableBundlesIn(new int[]{1, 0, 0, 0, 0});

        assertEquals(asList(asList(1)), allAvailableBundles);
    }

    @Test
    public void one_bundle_when_there_are_one_copy() throws Exception {
        List<List<Integer>> bundles = BookBundleFinder.findAllAvailableBundlesIn(new int[]{2, 2, 2, 1, 1});
        assertEquals(asList(asList(5,3), asList(4,4)), bundles);
    }
}
