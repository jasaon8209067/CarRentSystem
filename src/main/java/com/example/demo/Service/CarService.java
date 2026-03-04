package com.example.demo.Service;

import com.example.demo.Entity.Car;
import com.example.demo.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;
//    private List<Car> cars = new ArrayList<>();

    //取得所有
    public List<Car> getAllCar() {
        return carRepository.findAll();
    }

    //從id取得
    public Car getCarById(Long id) {
//        for (int i = 0; i < cars.size(); i++) {
//            Car carone = cars.get(i);
//            if (carone.getId().equals(id)) {
//                return carone;
//            }
//        }
//        System.out.println("無此車輛");
//        return null;
        return carRepository.findById(id).orElse(null);
    }

    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    public void deleteCarById(Long id) {
        carRepository.deleteById(id);
//        for (int i = 0; i < cars.size(); i++) {
//            Car carDelete = cars.get(i);
//            if (carDelete.getId().equals(id)) {
//                System.out.println("刪除車輛:" + carDelete);
//                return cars.remove(i);
//            }
//        }
//        System.out.println("無此車輛");
//        return null;
    }

    //更新車輛
    public Car updateCarById(Long id, Car car) {
        Car existing = carRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setcarName(car.getcarName());
            existing.setCountry(car.getCountry());
            existing.setCarNumber(car.getCarNumber());
            return carRepository.save(existing);
        }
        System.out.println("查無此車輛");
        return null;
    }

    //查詢同品牌車輛
    public List<Car> findSameBrandCar(String name) {
        return carRepository.findBycarName(name);
    }
}
