package com.binde.Backend.controller;

import com.binde.Backend.dto.BookDto;
import com.binde.Backend.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/book")
    public class BookController {
        private final BookService bookService;
        //  @PreAuthorize("hasRole('ADMIN')")
        @PostMapping("/add_books")
        public ResponseEntity<BookDto> addBook(@RequestBody BookDto bookDto){

          BookDto savedBook = bookService.addBook(bookDto);
          //return new ResponseEntity<>(todos, HttpStatus.201 created)
          return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
        }
        //@PreAuthorize("hasAnyRole('ADMIN','USER')")
        @GetMapping("/viewAll_books")
    public ResponseEntity<List<BookDto>> viewAllBooks(){
            List<BookDto> books = bookService.viewAllBooks();
            //return new ResponseEntity<>(todos, HttpStatus.OK);
            return ResponseEntity.ok(books);
    }
    //@PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/{id}")
        public ResponseEntity<BookDto> getBookById(@PathVariable Long id) {
            Optional<BookDto> optionalBookDto = bookService.getBookById(id);
    //return responseEntity is 200
            return optionalBookDto.map(bookDto -> ResponseEntity.ok()
                            .body(bookDto))
                    .orElseGet(() -> ResponseEntity
                            .notFound().build());
        }
    //    @PreAuthorize("hasRole('ADMIN')")
        @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteBook(@PathVariable("id") Long bookId){
            bookService.deleteBook(bookId);
            return ResponseEntity.ok("Book deleted successfully!");

        }
    //    @PreAuthorize("hasRole('ADMIN')")
        @PutMapping("update/{id}")
        public ResponseEntity<BookDto> updateBook(@PathVariable("id") Long id,
                                                  @RequestBody BookDto bookDto){
           BookDto updatedBook= bookService.updateBook(bookDto, id);
            return ResponseEntity.ok(updatedBook);

        }
}
