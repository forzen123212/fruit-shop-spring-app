package com.example.bookshop.service.impl;

import com.example.bookshop.domain.Book;
import com.example.bookshop.dto.book.BookDto;
import com.example.bookshop.dto.book.CreateBookRequestDto;
import com.example.bookshop.exception.EntityNotFoundException;
import com.example.bookshop.mapper.BookMapper;
import com.example.bookshop.repositories.BookRepository;
import com.example.bookshop.service.BookService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private static final String NO_BOOK_BY_ID_FOUND_MSG = "Can't find book by id: ";

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookDto save(CreateBookRequestDto bookDto) {
        return bookMapper
                .toBookDto(bookRepository.save(bookMapper.toModel(bookDto)));
    }

    @Override
    public List<BookDto> getAll(Pageable pageable) {
        return bookRepository.findAll(pageable).stream()
                .map(bookMapper::toBookDto)
                .toList();
    }

    public BookDto getById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(NO_BOOK_BY_ID_FOUND_MSG + id));
        return bookMapper.toBookDto(book);
    }

    @Override
    public BookDto update(Long id, CreateBookRequestDto requestDto) {
        if (bookRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException(NO_BOOK_BY_ID_FOUND_MSG);
        }
        Book book = bookMapper.toModel(requestDto);
        book.setId(id);
        return bookMapper.toBookDto((bookRepository.save(book)));
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
