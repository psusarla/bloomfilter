package com.msft;

import com.msft.hash.DefaultHashFunction;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestBitMapSizes {

    @Test
    public void spellChecks10000() throws Exception{
        BloomFilter bloomFilter = new BloomFilter(new DefaultHashFunction(), 10000);
        assertTrue(bloomFilter.checkSpelling("hello"));
        assertTrue(bloomFilter.checkSpelling("software"));

        //Below are false positives
        assertTrue(bloomFilter.checkSpelling("phani"));
        assertTrue(bloomFilter.checkSpelling("susarla"));
    }

    @Test
    public void spellChecks100000() throws Exception{
        BloomFilter bloomFilter = new BloomFilter(new DefaultHashFunction(), 100000);
        assertTrue(bloomFilter.checkSpelling("hello"));
        assertTrue(bloomFilter.checkSpelling("software"));

        //Below are false positives
        assertTrue(bloomFilter.checkSpelling("phani"));
        assertTrue(bloomFilter.checkSpelling("susarla"));
    }

    @Test
    public void spellChecks1000000() throws Exception{
        BloomFilter bloomFilter = new BloomFilter(new DefaultHashFunction(), 1000000);
        assertTrue(bloomFilter.checkSpelling("hello"));
        assertTrue(bloomFilter.checkSpelling("software"));

        //Below are correctly detect the spell checks
        assertFalse(bloomFilter.checkSpelling("phani"));
        assertFalse(bloomFilter.checkSpelling("susarla"));
    }

    @Test
    public void spellChecks10000000() throws Exception{
        BloomFilter bloomFilter = new BloomFilter(new DefaultHashFunction(), 10000000);
        assertTrue(bloomFilter.checkSpelling("hello"));
        assertTrue(bloomFilter.checkSpelling("software"));

        //Below are correctly detect the spell checks
        assertFalse(bloomFilter.checkSpelling("phani"));
        assertFalse(bloomFilter.checkSpelling("susarla"));
    }
}
