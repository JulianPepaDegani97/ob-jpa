package com.example.obrestdatajpa.services;

import com.example.obrestdatajpa.models.Book;
import com.example.obrestdatajpa.models.Laptop;
import com.example.obrestdatajpa.repositories.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LaptopServiceImpl implements LaptopService {

    @Autowired
    LaptopRepository laptopRepository;

    @Override
    public List<Laptop> findLaptops() {
        return laptopRepository.findAll();
    }

    @Override
    public Laptop findLaptopById(Long id) {
        return laptopRepository.findById(id).orElse(null);
    }

    @Override
    public void createLaptop(Laptop laptop) {
        laptopRepository.save(laptop);
    }

    @Override
    public void updateLaptop(Laptop laptop, Long id) {
        laptopRepository.save( mapearLaptopId(laptop, id));
    }

    @Override
    public Laptop mapearLaptopId(Laptop laptopDTO, Long id) {
        Laptop laptop = findLaptopById(id);
        laptop.setMarca(laptopDTO.getMarca());
        laptop.setModelo(laptopDTO.getModelo());
        laptop.setAnio(laptopDTO.getAnio());
        laptop.setPrecio(laptopDTO.getPrecio());
        return laptop;
    }

    @Override
    public void deleteLaptop(Long id) {
        laptopRepository.deleteById(id);
    }
}
