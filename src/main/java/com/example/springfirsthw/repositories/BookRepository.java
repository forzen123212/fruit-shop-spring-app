package com.example.springfirsthw.repositories;

import com.example.springfirsthw.domain.Book;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository {

    Book save(Book book);

    List<Book> findAll();

}
