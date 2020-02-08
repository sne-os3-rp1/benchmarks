package rdd;

import java.io.Serializable;

class Name implements Serializable
{
    private String value;

    public Name(final String value) {
        this.value = value;
    }

    public String getName() {
        return this.value;
    }
}