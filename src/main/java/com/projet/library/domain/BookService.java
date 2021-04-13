package com.projet.library.domain;

import com.projet.library.infra.BookEntity;
import com.projet.library.infra.BookRepository;
import com.projet.library.prez.books.SearchCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;
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
            if (ObjectUtils.isEmpty(searchCriteria.getAuthor())) {

            }
            return bookEntity;
        }).collect(Collectors.toList());
         */

       List<BookEntity> BookEntities = bookRepository.findByNameAndAuthor(searchCriteria.getName(), searchCriteria.getAuthor());
        if(BookEntities.size() !=0){

            return BookEntities;
        }
        else
            throw new BookNotFound();

    }

    public BookEntity bookByName(String name) {
        Optional<BookEntity> optionalBookEntity = bookRepository.findByName(name);
        return optionalBookEntity.orElseThrow(BookNotFound::new);
    }


}
