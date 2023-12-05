package com.example.springfirsthw.service.impl;

import java.util.List;
import com.example.springfirsthw.domain.Book;
import com.example.springfirsthw.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl {
    private final BookRepository bookRepository;

    @Autowired
    BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

}
