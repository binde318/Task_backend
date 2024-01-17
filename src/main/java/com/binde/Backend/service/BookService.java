package com.binde.Backend.service;


import com.binde.Backend.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<BookDto> viewAllBooks();
    BookDto addBook(BookDto bookDto);
    Optional<BookDto> getBookById(Long bookId);
    void deleteBook(Long bookId);
    BookDto updateBook(BookDto bookDt,Long id);
}
