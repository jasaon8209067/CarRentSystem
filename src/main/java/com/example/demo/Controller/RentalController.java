package com.example.demo.Controller;

import com.example.demo.Entity.Rental;
import com.example.demo.Service.RentalService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rental")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @PostMapping("/rent/{carId}")
    public String rentCar(@PathVariable Long carId, HttpSession session){
        String username = (String) session.getAttribute("loginUser");

        if(username == null){
            return "請先登入";
        }
        return rentalService.rentCar(carId,username);
    }

    @PostMapping("/return/{rentalId}")
    public String returnCar(@PathVariable Long rentalId){
        return rentalService.returnCar(rentalId);
    }


    @GetMapping("/all")
    public List<Rental> getAllRental(){
        return rentalService.showAllRental();
    }

    @GetMapping("/{id}")
    public Rental getRentalById(@PathVariable Long id){
        return rentalService.findRentalById(id);
    }

    @PostMapping("/add")
    public Rental addRental(@RequestBody Rental rental){
        return  rentalService.addRental(rental);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRentalById(@PathVariable Long id){
        rentalService.deleteRentalById(id);
    }

    @PutMapping("/update/{id}")
    public Rental updateRentalById(@PathVariable Long id, @RequestBody Rental rental){
        return rentalService.updateRentalById(id,rental);
    }
}
