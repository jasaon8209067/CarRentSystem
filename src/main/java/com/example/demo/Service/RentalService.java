package com.example.demo.Service;

import com.example.demo.Entity.Car;
import com.example.demo.Entity.Rental;
import com.example.demo.Entity.User;
import com.example.demo.Repository.CarRepository;
import com.example.demo.Repository.RentalRepository;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RentalService {
    @Autowired
    private RentalRepository rentalRepository;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private UserRepository userRepository;

    public String rentCar(Long carId, String username){
        Car car = carRepository.findById(carId).orElse(null);
        if(car == null){
            return "車輛不存在";
        }

        //判斷是否已被租借
        if(car.getStaus().equals("Rented")){
            return "車輛已被出租";
        }
        User user = userRepository.findByUsername(username);

        Rental rental = new Rental();
        rental.setCar(car);
        rental.setUser(user);
        rental.setRentalDate(LocalDate.now());
        rental.setStatus("Renting");

        //更新車的狀態
        car.setStaus("Rented");
        carRepository.save(car);
        rentalRepository.save(rental);

        return "租車成功";
    }

    //還車
    public String returnCar(Long rentalId){
        Rental rental = rentalRepository.findById(rentalId).orElse(null);

        if(rental == null){
            return "無此租借紀錄";
        }
        if(rental.getStatus().equals("Returned")){
            return "此車已被歸還";
        }
        rental.setStatus("Returned");
        rental.setReturnDate(LocalDate.now());

        Car car = rental.getCar();
        car.setStaus("Available");

        carRepository.save(car);
        rentalRepository.save(rental);

        return "還車成功";
    }

    public List<Rental> showAllRental() { return rentalRepository.findAll(); }

    public Rental findRentalById(Long id) {
        return rentalRepository.findById(id).orElse(null);
    }

    public Rental addRental(Rental rental){
        return rentalRepository.save(rental);
    }

    public void deleteRentalById(Long id){
        rentalRepository.deleteById(id);
    }

    public Rental updateRentalById(Long id, Rental rental){
        Rental existing = rentalRepository.findById(id).orElse(null);
        if(existing != null){
            existing.setCar(rental.getCar());
            existing.setUser(rental.getUser());
            existing.setRentalDate(rental.getRentalDate());
            existing.setReturnDate(rental.getReturnDate());
            return rentalRepository.save(existing);
        }
        return null;
    }

}
