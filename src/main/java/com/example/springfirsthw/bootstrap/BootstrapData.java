package com.example.springfirsthw.bootstrap;

import com.example.springfirsthw.domain.Book;
import com.example.springfirsthw.repositories.BookRepository;
import java.math.BigDecimal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final BookRepository bookRepository;

    public BootstrapData(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Book firstBook = new Book();
        firstBook.setAuthor("Yukio Mishima");
        firstBook.setTitle("The Mask");
        firstBook.setPrice(new BigDecimal(2000));
        firstBook.setIsbn("121231");

        Book firstBookSaved = bookRepository.save(firstBook);

        System.out.println(bookRepository.findAll());
    }
}
