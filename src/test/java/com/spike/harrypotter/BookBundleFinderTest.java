package com.spike.harrypotter;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.spike.harrypotter.BookBundleFinder.findOn;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class BookBundleFinderTest {
    @Test
    public void no_bundles_when_there_are_no_copies() throws Exception {
        List<Integer> bundles = findOn(new int[]{0, 0, 0, 0, 0});

        assertTrue(bundles.isEmpty());
    }

    @Test
    public void just_one_bundle() throws Exception {
        List<Integer> bundles = findOn(new int[]{1, 0, 0, 0, 0});
        assertEquals(asList(1), bundles);
    }

    @Test
    public void one_bundle_when_there_are_one_copy() throws Exception {
        List<Integer> bundles = findOn(new int[]{2, 2, 2, 1, 1});
        assertEquals(asList(5,3), bundles);

    }
}
