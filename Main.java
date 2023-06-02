package org.informatics;

import org.informatics.models.Book;
import org.informatics.models.BookForSelling;
import org.informatics.models.BookStore;
import org.informatics.models.BookType;
import org.informatics.service.BookStoreService;
import org.informatics.service.BookStoreServiceImpl;

public class Main {
    public static void main(String[] args) {

        Book book1 = new Book("Yan Bibiyan", 120, BookType.NOVEL);
        Book book2 = new Book("Yan Bibiyan na Lunata", 120, BookType.NOVEL);
        Book book3 = new Book("Aneto", 200, BookType.NOVEL);
        Book book4 = new Book("Divi Razkazi", 80, BookType.STORY_COLLECTION);

        BookForSelling bookForSelling1 = new BookForSelling(book1, 10, 10.5);
        BookForSelling bookForSelling2 = new BookForSelling(book2, 10, 11.2);
        BookForSelling bookForSelling3 = new BookForSelling(book3, 20, 10.5);
        BookForSelling bookForSelling4 = new BookForSelling(book4, 20, 12);
        BookForSelling bookForSelling5 = new BookForSelling(book1, 15, 12.5);
        BookForSelling bookForSelling6 = new BookForSelling(book2, 20, 12);
        BookForSelling bookForSelling7 = new BookForSelling(book3, 15, 11);
        BookForSelling bookForSelling8 = new BookForSelling(book4, 10, 13.5);

        BookStore bookStore = new BookStore("Helikon");

        BookStoreService bookStoreService = new BookStoreServiceImpl();

        bookStoreService.addBookToSellingReport(bookStore, bookForSelling1);
        bookStoreService.addBookToSellingReport(bookStore, bookForSelling2);
        bookStoreService.addBookToSellingReport(bookStore, bookForSelling3);
        bookStoreService.addBookToSellingReport(bookStore, bookForSelling4);
        bookStoreService.addBookToSellingReport(bookStore, bookForSelling5);
        bookStoreService.addBookToSellingReport(bookStore, bookForSelling6);
        bookStoreService.addBookToSellingReport(bookStore, bookForSelling7);
        bookStoreService.addBookToSellingReport(bookStore, bookForSelling8);

        bookStoreService.addBookRating(bookStore, bookForSelling1, 2);
        bookStoreService.addBookRating(bookStore, bookForSelling2, 5);
        bookStoreService.addBookRating(bookStore, bookForSelling3, 5);
        bookStoreService.addBookRating(bookStore, bookForSelling4, 4);
        bookStoreService.addBookRating(bookStore, bookForSelling5, 4);
        bookStoreService.addBookRating(bookStore, bookForSelling6, 3);
        bookStoreService.addBookRating(bookStore, bookForSelling7, 5);
        bookStoreService.addBookRating(bookStore, bookForSelling8, 3);

        bookStoreService.printBooksInSoldBooksReport(bookStore);

        bookStoreService.printBooksAndRatingBooksRating(bookStore);

        bookStoreService.soldBooksReportByBookForSellingBySellingPriceLessThan(bookStore, 11.2);

        bookStoreService.soldBooksReportTotalQuantityByBookType(bookStore, BookType.STORY_COLLECTION);

        bookStoreService.soldBooksReportAverageSellingPrice(bookStore);

        bookStoreService.soldBooksReportTotalSellingPriceByBookNumberOfPagesGreaterThan(bookStore, 120);

        bookStoreService.booksRatingHighestValue(bookStore);

        bookStoreService.booksRatingBooksWithHighestRating(bookStore);
        System.out.println("///////////////////////////////////////");
        bookStoreService.printBooksInSoldBooksReport(bookStore);
    }
}