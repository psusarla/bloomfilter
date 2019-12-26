package com.msft;

import com.msft.hash.ApacheHashFunction;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestApacheHashFunction {
    static BloomFilter bloomFilter = null;
    static int BITMAP_SIZE = 1000000;

    @BeforeClass
    public static void setup() throws Exception {
        bloomFilter = new BloomFilter(new ApacheHashFunction(),BITMAP_SIZE);
    }

    @Test
    public void spellChecks() {
        assertTrue(bloomFilter.checkSpelling("hello"));
        assertFalse(bloomFilter.checkSpelling("phani"));
    }
}