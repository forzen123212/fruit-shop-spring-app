package com.example.springfirsthw.service;

import com.example.springfirsthw.dto.BookDto;
import com.example.springfirsthw.dto.CreateBookRequestDto;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface BookService {
    BookDto save(CreateBookRequestDto bookDto);

    BookDto update(Long id, CreateBookRequestDto requestDto);

    List<BookDto> getAll(Pageable pageable);

    void deleteById(Long id);

    BookDto getById(Long id);
}
