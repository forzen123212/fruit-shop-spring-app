package com.example.springfirsthw.service;

import com.example.springfirsthw.domain.Book;
import java.util.List;

public interface BookService {
    Book save(Book book);

    List<Book> findAll();
}
