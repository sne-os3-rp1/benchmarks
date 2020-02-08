package rdd;

import java.util.stream.Stream;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.storage.StorageLevel;
import java.util.List;
import java.math.BigInteger;
import java.util.ArrayList;
import org.apache.spark.api.java.JavaSparkContext;
import java.util.Random;

public class Persistence
{
    private static Random rnd;
    private static final String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    static {
        Persistence.rnd = new Random(100000000L);
    }

    public static void main(String[] args) {
        JavaSparkContext sc = new JavaSparkContext();
        for (int i = 0; i < 50; ++i) {
            List<Person> persons = new ArrayList<Person>();
            for (int j = 0; j < 50000; ++j) {
                persons.add(new Person(new Name(getRandomString(8)), new Age(BigInteger.valueOf(j)), getBooks()));
            }
            System.out.println("Start writing");
            JavaRDD<Person> personRDD = (JavaRDD<Person>)sc.parallelize((List)persons, 4);
            personRDD.persist(StorageLevel.MEMORY_ONLY_SER());
            personRDD.count();
        }
        sc.close();
    }

    private static String getRandomString(final int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; ++i) {
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".charAt(Persistence.rnd.nextInt("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".length())));
        }
        return sb.toString();
    }

    private static Book[] getBooks() {
        return Stream.of(getRandomString(10)).map(title -> new Book(title)).toArray(Book[]::new);
    }
}