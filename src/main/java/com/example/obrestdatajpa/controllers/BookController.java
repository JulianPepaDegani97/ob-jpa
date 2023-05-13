package com.example.obrestdatajpa.controllers;

import com.example.obrestdatajpa.models.Book;
import com.example.obrestdatajpa.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookService.findBooks();
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id) {
        if(bookService.findBookById(id) != null) {
            return ResponseEntity.ok(bookService.findBookById(id));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/books")
    public ResponseEntity createBook(@RequestBody Book book) {
        if(book.getTitle().isEmpty() || book.getAuthor().isEmpty()) {
            return new ResponseEntity<>("Completar campos", HttpStatus.FORBIDDEN);
        }
        bookService.createBook(book);
        return new ResponseEntity<>("Libro almacenado en base de datos", HttpStatus.CREATED);
    }

    @PutMapping("/books")
    public ResponseEntity updateBook(@RequestBody Book book, @RequestParam Long id) {
        if(bookService.findBookById(id) == null) {
            return new ResponseEntity<>("Libro no encontrado", HttpStatus.NOT_FOUND);
        }
        if(book.getTitle().isEmpty() || book.getAuthor().isEmpty()) {
            return new ResponseEntity<>("Completar campos", HttpStatus.FORBIDDEN);
        }
        bookService.updateBook(book, id);
        return new ResponseEntity<>("Libro almacenado en base de datos", HttpStatus.OK);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity deleteBook(@PathParam("id") Long id) {
        if(bookService.findBookById(id) != null) {
            bookService.deleteBook(id);
            return new ResponseEntity<>("Libro eliminado de la base de datos", HttpStatus.OK);
        }
         return new ResponseEntity<>("Libro no encontrado", HttpStatus.NOT_FOUND);
    }
}
