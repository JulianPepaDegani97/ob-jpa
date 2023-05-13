package com.example.obrestdatajpa.repositories;

import com.example.obrestdatajpa.models.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepository extends JpaRepository<Laptop, Long> {
}
