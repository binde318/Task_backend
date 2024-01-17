package com.binde.Backend.service.serviceImpl;


import com.binde.Backend.dto.BookDto;
import com.binde.Backend.entity.Book;
import com.binde.Backend.exception.BookNotFoundException;
import com.binde.Backend.repository.BookRepository;
import com.binde.Backend.service.BookService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private ModelMapper modelMapper;

    @Override
    public List<BookDto> viewAllBooks() {
        List<Book> books = bookRepository.findAll();

        return books.stream()
                .map((todo) -> modelMapper.map(todo, BookDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public BookDto addBook(BookDto bookDto) {
        // convert BookDto into Book Jpa entity
        Book book = modelMapper.map(bookDto, Book.class);

        Book savedBook = bookRepository.save(book);

        // Convert saved Book Jpa entity object into BookDto object

        BookDto saveBookDto = modelMapper.map(savedBook, BookDto.class);

        return saveBookDto;
    }

    @Override
    public Optional<BookDto> getBookById(Long bookId) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);

        if (optionalBook.isPresent()) {
            // If the book is found, map it to BookDto and return the Optional containing BookDto
            BookDto bookDto = modelMapper.map(optionalBook.get(), BookDto.class);
            return Optional.of(bookDto);
        } else {
            // If the book is not found, return an empty Optional
        return Optional.empty();
        }
    }

    @Override
    public void deleteBook(Long bookId) {
        bookRepository.findById(bookId)
                .orElseThrow(()
                        -> new BookNotFoundException("book with the id is not found " + bookId));
        bookRepository.deleteById(bookId);
    }

    @Override
    public BookDto updateBook(BookDto bookDto, Long id) {

        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book with id not found : " + id));
        book.setTitle(book.getTitle());
        book.setAuthor(book.getAuthor());
        book.setEdition(book.getEdition());
        book.setPrice(book.getPrice());

        Book updatedBook = bookRepository.save(book);

        return modelMapper.map(updatedBook, BookDto.class);
    }

    }


