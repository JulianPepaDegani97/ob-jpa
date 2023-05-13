package com.example.obrestdatajpa.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    private String author;
    private Integer pages;
    private Double price;
    private LocalDate releaseDate;
    private Boolean ebook;


    public Book() {}
    public Book(String title, String author, Integer pages, Double price, LocalDate releaseDate, Boolean ebook) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.price = price;
        this.releaseDate = releaseDate;
        this.ebook = ebook;
    }

    public Long getId() {return id;}

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public String getAuthor() {return author;}
    public void setAuthor(String author) {this.author = author;}

    public Integer getPages() {return pages;}
    public void setPages(Integer pages) {this.pages = pages;}

    public Double getPrice() {return price;}
    public void setPrice(Double price) {this.price = price;}

    public LocalDate getReleaseDate() {return releaseDate;}
    public void setReleaseDate(LocalDate releaseDate) {this.releaseDate = releaseDate;}

    public Boolean getEbook() {return ebook;}
    public void setEbook(Boolean ebook) {this.ebook = ebook;}
}
