package org.informatics.models;

import java.util.UUID;

public class Book implements Comparable<Book> {
    private UUID uuid;
    private String name;
    private int numberOfPages;
    private BookType bookType;
    public Book(String name, int numberOfPages, BookType bookType) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.numberOfPages = numberOfPages;
        this.bookType = bookType;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public BookType getBookType() {
        return bookType;
    }

    @Override
    public String toString() {
        return "Book{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", bookType=" + bookType +
                '}';
    }
    @Override
    public int compareTo(Book other) {
        return Integer.compare(this.numberOfPages, other.numberOfPages);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Book other = (Book) obj;
        return uuid.equals(other.uuid);
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }
}
