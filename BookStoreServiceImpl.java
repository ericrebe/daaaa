package org.informatics.service;

import org.informatics.models.BookForSelling;
import org.informatics.models.BookStore;
import org.informatics.models.BookType;

import java.util.*;
import java.util.stream.Collectors;

public class BookStoreServiceImpl implements BookStoreService {
    private Map<BookStore, List<BookForSelling>> soldBooksReport;
    private Map<BookForSelling, Integer> booksRating;

    public BookStoreServiceImpl() {
        soldBooksReport = new HashMap<>();
        booksRating = new HashMap<>();
    }

    @Override
    public boolean addBookToSellingReport(BookStore bookStore, BookForSelling book) {
        List<BookForSelling> books = soldBooksReport.computeIfAbsent(bookStore, k -> new ArrayList<>());
        if (!books.contains(book)) {
            books.add(book);
            return true;
        }
        return false;
    }

    @Override
    public void addBookRating(BookStore bookStore, BookForSelling book, int rating) {
        booksRating.put(book, rating);
    }

    @Override
    public void printBooksInSoldBooksReport(BookStore bookStore) {
        List<BookForSelling> books = soldBooksReport.getOrDefault(bookStore, new ArrayList<>());
        books.forEach(System.out::println);
    }

    @Override
    public void printBooksAndRatingBooksRating(BookStore bookStore) {
        List<BookForSelling> books = soldBooksReport.getOrDefault(bookStore, new ArrayList<>());
        books.forEach(book -> {
            System.out.println(book);
            System.out.println("Rating: " + booksRating.getOrDefault(book, 0));
        });
    }

    @Override
    public Set<BookForSelling> soldBooksReportByBookForSellingBySellingPriceLessThan(BookStore bookStore, double limitPrice) {
        List<BookForSelling> books = soldBooksReport.getOrDefault(bookStore, new ArrayList<>());
        return books.stream()
                .filter(book -> book.getSellingPrice() < limitPrice)
                .collect(Collectors.toSet());
    }

    @Override
    public long soldBooksReportTotalQuantityByBookType(BookStore bookStore, BookType bookType) {
        List<BookForSelling> books = soldBooksReport.getOrDefault(bookStore, new ArrayList<>());
        return books.stream()
                .filter(bookForSelling -> bookForSelling.getBook().getBookType() == bookType)
                .mapToLong(BookForSelling::getQuantity)
                .sum();
    }


    @Override
    public double soldBooksReportAverageSellingPrice(BookStore bookStore) {
        List<BookForSelling> books = soldBooksReport.getOrDefault(bookStore, new ArrayList<>());
        return books.stream()
                .mapToDouble(BookForSelling::getSellingPrice)
                .average()
                .orElse(0);
    }

    @Override
    public double soldBooksReportTotalSellingPriceByBookNumberOfPagesGreaterThan(BookStore bookStore, int pagesLimit) {
        List<BookForSelling> books = soldBooksReport.getOrDefault(bookStore, new ArrayList<>());
        return books.stream()
                .filter(bookForSelling -> bookForSelling.getBook().getNumberOfPages() > pagesLimit)
                .mapToDouble(BookForSelling::getSellingPrice)
                .sum();
    }



    @Override
    public int booksRatingHighestValue(BookStore bookStore) {
        List<BookForSelling> books = soldBooksReport.getOrDefault(bookStore, new ArrayList<>());
        if (books != null) {
            return books.stream()
                    .mapToInt(book -> booksRating.getOrDefault(book, 0))
                    .max()
                    .orElse(0);
        }
        return 0;
    }

    @Override
    public Set<BookForSelling> booksRatingBooksWithHighestRating(BookStore bookStore) {
        List<BookForSelling> books = soldBooksReport.getOrDefault(bookStore, new ArrayList<>());
        if (books != null) {
            int highestRating = booksRatingHighestValue(bookStore);
            return books.stream()
                    .filter(book -> booksRating.getOrDefault(book, 0) == highestRating)
                    .collect(Collectors.toSet());
        }
        return new HashSet<>();
    }
}