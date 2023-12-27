package com.example.bookshop.service;

import com.example.bookshop.dto.book.BookDto;
import com.example.bookshop.dto.book.CreateBookRequestDto;
import java.util.List;

public interface BookService {
    BookDto save(CreateBookRequestDto bookDto);

    BookDto update(Long id, CreateBookRequestDto requestDto);

    List<BookDto> getAll();

    void deleteById(Long id);

    BookDto getById(Long id);
}
