package org.informatics.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.informatics.models.*;
import org.informatics.service.BookStoreService;
import org.informatics.service.BookStoreServiceImpl;

public class BookStoreServiceTest {
    private BookStoreService bookStoreService;
    private BookStore bookStore;

    @Before
    public void setup() {
        bookStoreService = new BookStoreServiceImpl();
        bookStore = new BookStore("My BookStore");
    }

    @Test
    public void testSoldBooksReportTotalQuantityByBookType() {
        // Arrange
        Book book1 = new Book("Book 1", 200, BookType.NOVEL);
        Book book2 = new Book("Book 2", 300, BookType.NOVEL);
        Book book3 = new Book("Book 3", 250, BookType.STORY_COLLECTION);
        BookForSelling bookForSelling1 = new BookForSelling(book1, 5, 20.0);
        BookForSelling bookForSelling2 = new BookForSelling(book2, 3, 25.0);
        BookForSelling bookForSelling3 = new BookForSelling(book3, 2, 30.0);
        bookStoreService.addBookToSellingReport(bookStore, bookForSelling1);
        bookStoreService.addBookToSellingReport(bookStore, bookForSelling2);
        bookStoreService.addBookToSellingReport(bookStore, bookForSelling3);

        // Act
        long quantityNovel = bookStoreService.soldBooksReportTotalQuantityByBookType(bookStore, BookType.NOVEL);
        long quantityStoryCollection = bookStoreService.soldBooksReportTotalQuantityByBookType(bookStore, BookType.STORY_COLLECTION);

        // Assert
        Assert.assertEquals(8, quantityNovel);
        Assert.assertEquals(2, quantityStoryCollection);
    }

    @Test
    public void testSoldBooksReportTotalSellingPriceByBookNumberOfPagesGreaterThan() {
        // Arrange
        Book book1 = new Book("Book 1", 200, BookType.NOVEL);
        Book book2 = new Book("Book 2", 300, BookType.NOVEL);
        Book book3 = new Book("Book 3", 260, BookType.STORY_COLLECTION);
        BookForSelling bookForSelling1 = new BookForSelling(book1, 5, 20.0);
        BookForSelling bookForSelling2 = new BookForSelling(book2, 3, 25.0);
        BookForSelling bookForSelling3 = new BookForSelling(book3, 2, 30.0);
        bookStoreService.addBookToSellingReport(bookStore, bookForSelling1);
        bookStoreService.addBookToSellingReport(bookStore, bookForSelling2);
        bookStoreService.addBookToSellingReport(bookStore, bookForSelling3);

        // Act
        double totalSellingPrice = bookStoreService.soldBooksReportTotalSellingPriceByBookNumberOfPagesGreaterThan(bookStore, 250);

        // Assert
        Assert.assertEquals(55, totalSellingPrice, 0.001);
    }
}
