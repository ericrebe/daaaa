package org.informatics.models;

public class BookForSelling {
    private Book book;
    private long quantity;
    private double sellingPrice;

    public BookForSelling(Book book, long quantity, double sellingPrice) {
        this.book = book;
        this.quantity = quantity;
        this.sellingPrice = sellingPrice;
    }

    public Book getBook() {
        return book;
    }

    public long getQuantity() {
        return quantity;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    @Override
    public String toString() {
        return "BookForSelling{" +
                "book=" + book +
                ", quantity=" + quantity +
                ", sellingPrice=" + sellingPrice +
                '}';
    }
}
