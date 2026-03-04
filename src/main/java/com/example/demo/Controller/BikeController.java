package com.example.demo.Controller;

import com.example.demo.Entity.Bike;
import com.example.demo.Service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BikeController {
    @Autowired
    private BikeService bikeService;

    @GetMapping("/bike")
    public Bike getBike(){
        return new Bike(1L, "SYM", "黑色", 123);
    }

    @GetMapping("/bikes")
    public List<Bike> getAllBike(){
        return bikeService.getAllBike();
    }
    @GetMapping("/bike/{id}")
    public Bike getBikeById(@PathVariable Long id){
        return bikeService.getBikeById(id);

    }

    @PostMapping("/bike/add")
    public Bike addBike(@RequestBody Bike bike){
        return bikeService.addBike(bike);
    }

    @DeleteMapping("/bike/{id}")
    public ResponseEntity<?> deleteBikeById(@PathVariable Long id){
        Bike deleted = bikeService.deleteBikeById(id);
        if(deleted == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deleted);
    }

    @PutMapping("/bike/{id}")
    public ResponseEntity<?> updateBike(
            @PathVariable Long id,
            @RequestBody Bike bike) {
        Bike updated = bikeService.updateBike(id, bike);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }
}
