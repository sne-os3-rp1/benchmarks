package rdd;

import java.math.BigInteger;
import java.io.Serializable;

class Age implements Serializable
{
    private BigInteger value;

    public Age(final BigInteger value) {
        this.value = value;
    }

    public BigInteger getAge() {
        return this.value;
    }
}