package com.msft;

import com.msft.hash.DefaultHashFunction;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.Random;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestBloomFilter {
    static BloomFilter bloomFilter = null;
    static int BITMAP_SIZE = 10000000;

    @BeforeClass
    public static void setup() throws Exception {
        bloomFilter = new BloomFilter(new DefaultHashFunction(), BITMAP_SIZE);
    }

    @Test
    public void spellChecks() {
        assertTrue(bloomFilter.checkSpelling("hello"));
        assertFalse(bloomFilter.checkSpelling("phani"));
    }

    @Test
    public void randomStrings() {
        for (int i = 0; i< 100; i++) {
            String str = generateRandomString(5);
            System.out.println("Spell Check for " + str + " was " + bloomFilter.checkSpelling(str));
        }
    }

    private String generateRandomString(int length) {
        int leftLimit = 97;
        int rightLimit = 122;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }
}