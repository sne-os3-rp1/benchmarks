package rdd;

import java.io.Serializable;

class Book implements Serializable
{
    private String title;

    public Book(String title) {
        this.title = title;
    }
}