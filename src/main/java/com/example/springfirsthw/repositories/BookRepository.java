package com.example.springfirsthw.repositories;

import com.example.springfirsthw.domain.Book;
import java.util.List;
import java.util.Optional;

public interface BookRepository {

    Book save(Book book);

    List<Book> findAll();

    Optional<Book> getById(Long id);

}


