package com.example.demo.Repository;

import com.example.demo.Entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Long> {
    List<Rental> findByCarIdAndStatus(Long carid, String status);//判斷車子是否正在租借中
}
