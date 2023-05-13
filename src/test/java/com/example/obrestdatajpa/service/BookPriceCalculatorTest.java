package com.example.obrestdatajpa.service;

import com.example.obrestdatajpa.models.Book;
import com.example.obrestdatajpa.services.BookPriceCalculator;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookPriceCalculatorTest {

    @Test
    void calculatePrice() {
        Book book = new Book("Martín Fierro", "José Hernández", 150, 30.5, LocalDate.now(), true);
        BookPriceCalculator calculator = new BookPriceCalculator();

        double price = calculator.calculatePrice(book);

        assertTrue(price > 0);
    }
}