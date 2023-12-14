package com.example.springfirsthw.service;

import com.example.springfirsthw.dto.BookDto;
import com.example.springfirsthw.dto.CreateBookRequestDto;
import java.util.List;

public interface BookService {
    BookDto save(CreateBookRequestDto book);

    BookDto update(Long id, CreateBookRequestDto requestDto);

    List<BookDto> getAll();

    void deleteById(Long id);

    BookDto getById(Long id);
}
