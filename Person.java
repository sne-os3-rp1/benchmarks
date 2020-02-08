package rdd;

import java.io.Serializable;

public class Person implements Serializable
{
    private static final long serialVersionUID = 42L;
    private Name name;
    private Age age;
    private Book[] books;

    public Person(Name name, Age age, Book[] books) {
        this.name = name;
        this.age = age;
        this.books = books;
    }
}
