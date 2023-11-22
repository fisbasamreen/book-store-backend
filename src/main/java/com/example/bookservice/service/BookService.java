package com.example.bookservice.service;

import com.example.bookservice.model.Book;
import com.example.bookservice.repository.BookStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookStoreRepository bookStoreRepository;

    public List<Book> getAllBooks() {
        return bookStoreRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookStoreRepository.findById(id).orElse(null);
    }

    public Book createBook(Book book) {
        return bookStoreRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookStoreRepository.deleteById(id);
    }

    public Book updateBook(Long id, Book updatedBook) {
        Book existingBook = bookStoreRepository.findById(id).orElse(null);

        if (existingBook != null) {
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setImageUrl(updatedBook.getImageUrl());
            existingBook.setPrice(updatedBook.getPrice());

            // Save the updated book to the repository
            return bookStoreRepository.save(existingBook);
        }

        return null;
    }

}
