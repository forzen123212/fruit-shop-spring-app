package com.example.springfirsthw.mapper;

import com.example.springfirsthw.config.MapperConfig;
import com.example.springfirsthw.domain.Book;
import com.example.springfirsthw.dto.BookDto;
import com.example.springfirsthw.dto.CreateBookRequestDto;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    BookDto toBookDto(Book book);

    Book toModel(CreateBookRequestDto bookRequestDto);
}
