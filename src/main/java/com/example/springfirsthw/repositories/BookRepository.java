package com.example.springfirsthw.repositories;

import java.util.List;
import com.example.springfirsthw.domain.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository {

    Book save(Book book);

    List<Book> findAll();

}
