package com.example.demo.Controller;

import com.example.demo.Entity.Car;
import com.example.demo.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/all")
    public List<Car> showAllCar(){
        return carService.getAllCar();
    }

    @GetMapping("/{id}")
    public Car findCarById(@PathVariable Long id){
        return carService.getCarById(id);
    }

    @PostMapping("/add")
    public Car addCar(@RequestBody Car car){
        return carService.addCar(car);
    }

    @PutMapping("/update/{id}")
    public Car updateCarById (@PathVariable Long id ,@RequestBody Car car){
        return carService.updateCarById(id, car);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteCarById(@PathVariable Long id){
        carService.deleteCarById(id);
    }

    @GetMapping("/find/{name}")
    public List<Car> findSameNameCar(@PathVariable String name){
        return carService.findSameBrandCar(name);
    }
}
