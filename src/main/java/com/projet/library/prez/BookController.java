package com.projet.library.prez;

import com.projet.library.domain.BookService;
import com.projet.library.infra.BookEntity;
import com.projet.library.prez.books.SearchCriteria;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.projet.library.prez.Constants.*;

@RestController
@Slf4j
public class BookController {

    @Autowired
    public BookService bookService;

    @GetMapping(BOOK_BASE_URL)
    public ResponseEntity getBooks(@RequestBody(required = false) SearchCriteria searchCriteria) {
        return ResponseEntity.ok(bookService.getBooks(searchCriteria));
    }

    @PostMapping(BOOK_BASE_URL)
    public ResponseEntity<String> addBook(@RequestBody BookEntity bookEntity) {
        bookService.addBook(bookEntity);
        return new ResponseEntity<>(" BOOK is CREATED ", HttpStatus.CREATED);
    }

    @PutMapping(BOOK_URL_BY_NAME)
    public ResponseEntity<String> updateBooks(@PathVariable String author) {
        bookService.updateBooksByAuthor(author);
        return new ResponseEntity<>(" BOOKS IS UPDATED ", HttpStatus.ACCEPTED);
    }

}
