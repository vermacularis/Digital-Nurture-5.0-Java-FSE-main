package com.library.service;

import com.library.repository.BookRepository;

import java.util.List;

/**
 * Service layer. Its BookRepository dependency is injected by the Spring IoC
 * container (Exercise 2: Dependency Injection) rather than created with `new`.
 *
 * This class exposes BOTH styles so the XML can demonstrate either:
 *   - Setter injection  (setBookRepository)
 *   - Constructor injection (BookService(BookRepository))
 */
public class BookService {

    private BookRepository bookRepository;

    /** No-arg constructor required for setter injection. */
    public BookService() {
    }

    /** Constructor injection. */
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /** Setter injection. */
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void listBooks() {
        System.out.println("=== Library Catalog ===");
        List<String> books = bookRepository.getAllBooks();
        for (String book : books) {
            System.out.println(" - " + book);
        }
        System.out.println("Total books: " + books.size());
    }
}
