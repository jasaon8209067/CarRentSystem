package com.example.demo.Repository;

import com.example.demo.Entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findBycarName(String name);
}
