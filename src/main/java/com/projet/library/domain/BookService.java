package com.projet.library.domain;

import com.projet.library.infra.BookEntity;
import com.projet.library.infra.BookRepository;
import com.projet.library.prez.books.SearchCriteria;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public void addBook(BookEntity bookEntity) {
        bookRepository.save(bookEntity);
    }

    @Cacheable(cacheNames = "Books")
    public List<BookEntity> Books(SearchCriteria searchCriteria)
    {
            return bookRepository.findAll();
    }

    public List<BookEntity> getBooks(SearchCriteria searchCriteria)
    {
        /*return bookRepository.findAll().stream().map(bookEntity -> {
            if (ObjectUtils.isEmpty(searchCriteria.getAuthor())) {}
            return bookEntity;
        }).collect(Collectors.toList());
         */
       List<BookEntity> bookEntities = bookRepository.findByNameAndAuthor(searchCriteria.getName(), searchCriteria.getAuthor());
        if(bookEntities.size() !=0)
        {
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
        log.info("find the books by :"+author);

        bookRepository.deleteAll(bookEntities);
        log.info("delete All books");

        List<BookEntity> newBookEntities = new ArrayList<>();
     /*
        long mostSigBits = 12345678910L;
        long leastSigBits = 9999999990L;
        UUID uuid = new UUID(mostSigBits, leastSigBits);
      */
        //newBookEntities.add(new BookEntity( "book3", "authorbook3", "description", LocalDate.of(2020, 1, 8)));
        bookRepository.saveAll(newBookEntities);
        log.info("save All books");
    }


}
