package com.projet.library.domain;

import com.projet.library.infra.BookEntity;
import com.projet.library.infra.BookRepository;
import com.projet.library.prez.books.SearchCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public void addBook(BookEntity bookEntity) {
        bookRepository.save(bookEntity);
    }

    public List<BookEntity> getBooks(SearchCriteria searchCriteria) {

        /*return bookRepository.findAll().stream().map(bookEntity -> {
            if (ObjectUtils.isEmpty(searchCriteria.getAuthor())) {}
            return bookEntity;
        }).collect(Collectors.toList());
         */

       List<BookEntity> bookEntities = bookRepository.findByNameAndAuthor(searchCriteria.getName(), searchCriteria.getAuthor());
        if(bookEntities.size() !=0){

            return bookEntities;
        }
        else
            throw new BookNotFound();

    }

    public BookEntity bookByName(String name) {
        Optional<BookEntity> optionalBookEntity = bookRepository.findByName(name);
        return optionalBookEntity.orElseThrow(BookNotFound::new);
    }

    @Transactional
    public void updateBooksByAuthor(String author){

        List<BookEntity> bookEntities = bookRepository.findByAuthor(author);
        bookRepository.deleteAll(bookEntities);

        List<BookEntity> newBookEntities = new ArrayList<>();

        long mostSigBits = 12345678910L;
        long leastSigBits = 9999999990L;
        UUID uuid = new UUID(mostSigBits, leastSigBits);
        newBookEntities.add(new BookEntity(uuid, "book3", "authorbook3", "description", LocalDate.of(2020, 1, 8)));

        bookRepository.saveAll(newBookEntities);

    }


}
