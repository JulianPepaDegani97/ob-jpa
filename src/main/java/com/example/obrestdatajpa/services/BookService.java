package com.example.obrestdatajpa.services;

import com.example.obrestdatajpa.models.Book;

import java.util.List;

public interface BookService {

    List<Book> findBooks();

    Book findBookById(Long id);

    void createBook(Book book);

    void updateBook(Book book, Long id);

    Book mapearLibroId(Book book, Long id);

    void deleteBook(Long id);
}
