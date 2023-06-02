package org.informatics.service;

import org.informatics.models.BookForSelling;
import org.informatics.models.BookStore;
import org.informatics.models.BookType;

import java.util.Set;

public interface BookStoreService {
    /**
     * @param bookStore
     * @param book
     * @return true if the book is added to the soldBooks, return false otherwise
     */
    boolean addBookToSellingReport(BookStore bookStore, BookForSelling book);

    /**
     * @param bookStore
     * @param book
     * @param rating
     */
    void addBookRating(BookStore bookStore, BookForSelling book, int rating);

    /**
     * @param bookStore
     */
    void printBooksInSoldBooksReport(BookStore bookStore);

    /**
     * @param bookStore
     */
    void printBooksAndRatingBooksRating(BookStore bookStore);

    /**
     * @param bookStore
     * @param limitPrice
     * @return set of selling books which selling price is less than limitPrice
     */
    Set<BookForSelling> soldBooksReportByBookForSellingBySellingPriceLessThan(BookStore bookStore, double limitPrice);

    /**
     * @param bookStore
     * @param bookType
     * @return the quantity of books which belong to given bookType
     */
    long soldBooksReportTotalQuantityByBookType(BookStore bookStore, BookType bookType);

    /**
     * @param bookStore
     * @return the average selling price of the books in soldBooksReport
     */
    double soldBooksReportAverageSellingPrice(BookStore bookStore);

    /**
     * @param bookStore
     * @param pagesLimit
     * @return the total selling price of the books which number of pages is greater than
     */
    double soldBooksReportTotalSellingPriceByBookNumberOfPagesGreaterThan(BookStore bookStore, int pagesLimit);

    /**
     * @param bookStore
     * @return the max value of the rating
     */
    int booksRatingHighestValue(BookStore bookStore);

    /**
     * @param bookStore
     * @return the set of book fo selling with the max value of the rating
     */
    Set<BookForSelling> booksRatingBooksWithHighestRating(BookStore bookStore);
}

