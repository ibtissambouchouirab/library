package com.projet.library.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, UUID> {

    Optional<BookEntity> findByName(String name);

    //@Query("SELECT b FROM BOOK b WHERE (:name is null or b.name = :name) and (:author is null or b.author = :author)")
   List<BookEntity> findByNameAndAuthor( String name,String author);

    List<BookEntity> findByAuthor( String author);

}
