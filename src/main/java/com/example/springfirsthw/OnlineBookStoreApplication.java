package com.example.springfirsthw;

import com.example.springfirsthw.domain.Book;
import com.example.springfirsthw.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class OnlineBookStoreApplication {

    @Autowired
    BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(OnlineBookStoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            Book book = new Book();
            book.setTitle("The Great Gatsby");
            book.setAuthor("Scott Fitzgerald");
            book.setIsbn("9780333791035");
            book.setPrice(BigDecimal.valueOf(100L));
            book.setDescription("Some description");

            bookService.save(book);
            System.out.println(bookService.findAll());
        };
    }
}
