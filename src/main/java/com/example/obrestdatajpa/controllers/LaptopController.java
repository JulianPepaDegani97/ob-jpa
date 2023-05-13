package com.example.obrestdatajpa.controllers;


import com.example.obrestdatajpa.models.Laptop;
import com.example.obrestdatajpa.services.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LaptopController {

    @Autowired
    LaptopService laptopService;

    @GetMapping("/laptops")
    public List<Laptop> findLaptops() {
        return laptopService.findLaptops();
    }

    @GetMapping("/laptops/{id}")
    public ResponseEntity<Laptop> findLaptopById(@PathVariable("id") Long id) {
        if(laptopService.findLaptopById(id) != null) {
            return ResponseEntity.ok(laptopService.findLaptopById(id));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/laptops")
    public ResponseEntity saveLaptop(@RequestBody Laptop laptop) {
        if(laptop.getMarca().isEmpty() || laptop.getModelo().isEmpty()) {
            return new ResponseEntity<>("Complete los campos", HttpStatus.FORBIDDEN);
        }
        laptopService.createLaptop(laptop);
        return new ResponseEntity<>("Laptop almacenada en base de datos", HttpStatus.CREATED);
    }

    @PutMapping("/laptops/{id}")
    public ResponseEntity updateLaptop(@RequestBody Laptop laptop, @PathVariable("id") Long id) {
        if(laptopService.findLaptopById(id) == null) {
            return new ResponseEntity<>("Ningún elemento en la base de datos posee el ID ingresado", HttpStatus.NOT_FOUND);
        }
        if(laptop.getMarca().isEmpty() || laptop.getModelo().isEmpty()) {
            return new ResponseEntity<>("Complete los campos", HttpStatus.FORBIDDEN);
        }
        laptopService.updateLaptop(laptop, id);
        return new ResponseEntity<>("Datos actualizados", HttpStatus.OK);
    }

    @DeleteMapping("/laptops/{id}")
    public ResponseEntity deleteLaptop(@PathVariable("id") Long id) {
        if(laptopService.findLaptopById(id) == null) {
            return new ResponseEntity<>("Ningún elemento en la base de datos posee el ID ingresado", HttpStatus.NOT_FOUND);
        }
        laptopService.deleteLaptop(id);
        return new ResponseEntity<>("Elemento eliminado de base de datos", HttpStatus.OK);
    }

}
