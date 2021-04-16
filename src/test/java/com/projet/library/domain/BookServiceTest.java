package com.projet.library.domain;

import com.projet.library.infra.BookEntity;
import com.projet.library.infra.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.Mockito.when;


@Slf4j
@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {


   @Mock // mock because we don't want to call actual repo class
   private BookRepository bookRepository;

   @InjectMocks
   private BookService bookService;

    @Test
    @Disabled
    public void Should_add_Book(){
        BookEntity bookEntity = new BookEntity();
        bookEntity.setName("I Love You to the Moon and Back");
        bookEntity.setAuthor("Amelia Hepworth");
        bookService.addBook(bookEntity);
        Mockito.verify(bookRepository,Mockito.times(1)).save(Mockito.any(BookEntity.class));
    }

    @Test
    public void Should_return_Book() throws Exception {
        when(bookRepository.findByName("Amelia Hepworth")).thenReturn(Optional.of(BookEntity.builder().build()));
        Assertions.assertThat(bookService.bookByName("Amelia Hepworth")).isNotNull();
    }

    @Test
    public void Should_return_Book_By_Name() throws Exception {
        when(bookRepository.findByName("Amelia Hepworth")).thenReturn(Optional.of(BookEntity.builder().build()));
        Assertions.assertThat(bookService.bookByName("Amelia Hepworth")).isNotNull();
    }



}
