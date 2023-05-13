package com.example.obrestdatajpa.models;

import javax.persistence.*;

@Entity
@Table(name = "ordenadores")
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marca;
    private String modelo;
    private Integer anio;
    private Double precio;


    public Laptop() {}

    public Laptop(String marca, String modelo, Integer anio, Double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.precio = precio;
    }

    public Long getId() {return id;}

    public String getMarca() {return marca;}
    public void setMarca(String marca) {this.marca = marca;}

    public String getModelo() {return modelo;}
    public void setModelo(String modelo) {this.modelo = modelo;}

    public Integer getAnio() {return anio;}
    public void setAnio(Integer anio) {this.anio = anio;}

    public Double getPrecio() {return precio;}
    public void setPrecio(Double precio) {this.precio = precio;}
}
