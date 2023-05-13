package com.example.obrestdatajpa.services;

import com.example.obrestdatajpa.models.Book;
import com.example.obrestdatajpa.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> findBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book findBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void createBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book mapearLibroId(Book bookDTO, Long id) {
        Book book = bookRepository.findById(id).orElse(null);
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setPages(bookDTO.getPages());
        book.setPrice(bookDTO.getPrice());
        book.setReleaseDate(bookDTO.getReleaseDate());
        book.setEbook(bookDTO.getEbook());
        return book;
    }

    @Override
    public void updateBook(Book book, Long id) {
        bookRepository.save(mapearLibroId(book, id));
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
