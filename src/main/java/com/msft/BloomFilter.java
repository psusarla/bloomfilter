package com.msft;

import com.msft.hash.HashFunction;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BloomFilter {
    private HashFunction hashFunction = null;
    private int[] bitMap = null;

    public BloomFilter(HashFunction hashFunction, int size) throws IOException{
     this.hashFunction = hashFunction;
     this.bitMap = loadAndMapDictionary(new int[size]);
    }

    /* This function reads the file line by line without loading everything in memory
      For each line (which is a word in our case), it calculates the hash and populates the bitmap
      The bitmap should be cached in a real implementation */
    private int[] loadAndMapDictionary(int[] inputBitmap) throws IOException{
        FileInputStream inputStream = null;
        Scanner sc = null;
        int length = inputBitmap.length;
        try {
            //TODO - Wordlist is loaded from the project. Optionally it can be loaded from the Linux file system or downloaded from the internet
            inputStream = new FileInputStream("wordlist.txt");
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                int pos = hashFunction.hashCode(line) % length; //As has can be negative, getting the absolute value
                inputBitmap[pos] = 1;
            }

            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (sc != null) {
                sc.close();
            }
        }
        return inputBitmap;
    }

    public boolean checkSpelling(String word) {
        if (word == null) {
            return false;
        }
        word = word.toLowerCase();
        int pos = hashFunction.hashCode(word) % this.bitMap.length;
        if (this.bitMap[pos] == 1) {
            return true;
        }
        return false;
    }

    //This is a naive implementation - it attempts to load the entire file to memory which is ineffective in our case
    private List<String> loadDictionary() throws IOException {
        int i = 0;
        List<String> allwordsList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("wordlist.txt"))) {
            i++;
            if ( i > 1000) {
                return allwordsList;
            }
            String line;
            while ((line = br.readLine()) != null) {
                allwordsList.add(line);
            }
        }
        return loadDictionary();
    }
}