package com.msft.hash;

import org.apache.commons.lang3.builder.HashCodeBuilder;

//Uses Apache's hascode builder
public class ApacheHashFunction implements HashFunction {

    @Override
    public int hashCode(String str) {
        return Math.abs(new HashCodeBuilder()
                .append(str)
                .toHashCode());
    }
}
