package com.msft.hash;

//Uses Java's default hashcode builder
public class DefaultHashFunction implements HashFunction{

    @Override
    public int hashCode(String str) {
        return Math.abs(str.hashCode());
    }
}
