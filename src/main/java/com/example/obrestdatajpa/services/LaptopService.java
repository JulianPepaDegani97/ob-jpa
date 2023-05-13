package com.example.obrestdatajpa.services;

import com.example.obrestdatajpa.models.Laptop;

import java.util.List;

public interface LaptopService {

    List<Laptop> findLaptops();

    Laptop findLaptopById(Long id);

    void createLaptop(Laptop laptop);

    void updateLaptop(Laptop laptop, Long id);

    Laptop mapearLaptopId(Laptop laptop, Long id);

    void deleteLaptop(Long id);
}
