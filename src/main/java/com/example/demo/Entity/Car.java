package com.example.demo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String carName;
    private String country;
    private String carNumber;

    @Column(nullable = false)
    private String staus; //available/rented

    public Car() {
    }

    public Car(Long id, String carName, String country, String carNumber) {
        this.id = id;
        this.carName = carName;
        this.country = country;
        this.carNumber = carNumber;
        this.staus = "Available";//預設可以租
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getcarName() {
        return carName;
    }

    public void setcarName(String name) {
        this.carName = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getStaus() { return staus; }

    public void setStaus(String staus) {
        this.staus = staus;
    }
}
