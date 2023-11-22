package com.example.bookservice.repository;

import com.example.bookservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookStoreRepository extends JpaRepository<Book, Long> {
}
