package com.example.demo.Service;

import com.example.demo.Entity.Bike;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BikeService {
    private List<Bike> bikes = new ArrayList<>();

    public Bike addBike(Bike bike) {
        bikes.add(bike);
        return bike;
    }

    public List<Bike> getAllBike() {
        return bikes;
    }

    public Bike getBikeById(Long id) {
        for (Bike b : bikes) {
            if (b.getId().equals(id)) {
                return b;
            }
        }
        System.out.println("查無此bike");
        return null;
    }

    public Bike deleteBikeById(Long id) {
        for (int i = 0; i < bikes.size(); i++) {
            if (bikes.get(i).getId().equals(id)) {
                return bikes.remove(i);
            }
        }
        System.out.println("查無此bike");
        return null;
    }

    public Bike updateBike(Long id, Bike updatedBike) {
        for (Bike b : bikes) {
            if (b.getId().equals(id)) {
                b.setBrand(updatedBike.getBrand());
                b.setColor(updatedBike.getColor());
                b.setBikeNumber(updatedBike.getBikeNumber());
                return b;
            }
        }
        return null;
    }
}
