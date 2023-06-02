package org.informatics.models;

import java.util.*;

public class BookStore {
    private String name;
    private Set<BookForSelling> soldBooksReport;
    private Map<BookForSelling, Integer> booksRating;
    public BookStore(String name) {
        this.name = name;
        this.soldBooksReport = new LinkedHashSet<>();
        this.booksRating = new HashMap<>();
    }
    public String getName() {
        return name;
    }
    public Set<BookForSelling> getSoldBooksReport() {
        return soldBooksReport;
    }
    public Map<BookForSelling, Integer> getBooksRating() {
        return booksRating;
    }
    @Override
    public String toString() {
        return "BookStore{" +
                "name='" + name + '\'' +
                '}';
    }
}
