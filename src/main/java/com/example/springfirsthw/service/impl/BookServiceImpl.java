package com.example.springfirsthw.service.impl;

import com.example.springfirsthw.domain.Book;
import com.example.springfirsthw.repositories.BookRepository;

public class BookServiceImpl {
    private final BookRepository bookRepository;

    BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

}
