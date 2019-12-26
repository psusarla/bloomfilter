package com.msft;

import com.msft.hash.DefaultHashFunction;

public class SampleApplication {
    public static void main (String args[]) {
        BloomFilter bloomFilter = null;
        try {
            //Application gets to choose the Hash Function and bitmap size based on available memory and its tolerance to false positives
            bloomFilter = new BloomFilter(new DefaultHashFunction(), 10000000);
        } catch (Exception e) {
            //TODO - In a production application, this should be written to a log file
            System.out.println("Unable to initialize BloomFilter " + e.getMessage());
            return;
        }

        //TODO - in real world, BloomFilter instance should be cached as its pre-processing (read the file and building the bitmap) is expensive
        System.out.println("Spell check result for string 'hello' " + bloomFilter.checkSpelling("happy"));
        System.out.println("Spell check result for string 'new' " + bloomFilter.checkSpelling("new"));
        System.out.println("Spell check result for string 'year' " + bloomFilter.checkSpelling("year"));
        System.out.println("Spell check result for string 'Year' " + bloomFilter.checkSpelling("Year"));
        System.out.println("Spell check result for string null " + bloomFilter.checkSpelling(null));
    }
}
