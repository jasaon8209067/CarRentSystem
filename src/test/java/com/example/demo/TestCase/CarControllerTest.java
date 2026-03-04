package com.example.demo.TestCase;

import com.example.demo.Controller.CarController;
import com.example.demo.Entity.Car;
import com.example.demo.Service.CarService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CarController.class)
public class CarControllerTest {

    @Autowired
    private MockMvc mockMvc; //注入MockMvc用來模擬發送 GET/POST 請求
    @MockBean
    private CarService carService; //模擬Service，不會真的去跑Service邏輯
    @Autowired
    private ObjectMapper objectMapper; //把物件轉成JSON字串

    @Test
    public void testGetAllCar() throws Exception{
        //設定假資料
        Car car1 = new Car(1L, "Toyota", "Japan",123456);
        Car car2 = new Car(2L, "Honda", "Japan", 456789);
        //模擬呼叫getAllCar時回傳這兩台車
        Mockito.when(carService.getAllCar()).thenReturn(Arrays.asList(car1, car2));
        //執行測試並驗證
        mockMvc.perform(get("/api/car/all"))
                .andExpect(status().isOk())//回傳 200 OK
                .andExpect(jsonPath("$.size()").value(2))//回傳JSON陣列長度是 2
                .andExpect(jsonPath("$[0].name").value("Toyota"))//檢查第一台車
                .andExpect(jsonPath("$[1].name").value("Honda"));//檢查第二台車
    }

    @Test
    public void testAddCar() throws Exception{
        Car newCar = new Car(3L, "BMW", "Germany", 159951);
        Mockito.when(carService.addCar(Mockito.any(Car.class))).thenReturn(newCar);

        mockMvc.perform(post("/api/car/add")
                .contentType(MediaType.APPLICATION_JSON)//設定傳送格式為JSON
                .content(objectMapper.writeValueAsString(newCar)))//把物件轉為JSON
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("BMW"));
    }

    @Test
    public void testUpdateCar() throws Exception{
        Long carId = 1l;
        Car updatedCar = new Car(carId, "Ford", "Taiwan", 741852);

        Mockito.when(carService.updateCarById(Mockito.eq(carId), Mockito.any(Car.class)))
                .thenReturn(updatedCar);

        mockMvc.perform(put("/api/car/update/{id}", carId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedCar)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Ford"))
                .andExpect(jsonPath("$.country").value("Taiwan"));

    }

    @Test
    public void testDeleteCar()throws Exception{
        Long carId = 2L;
        Car deletedCar = new Car(carId, "Honda", "Japan", 456789);

        Mockito.when(carService.deleteCarById(carId)).thenReturn(deletedCar);

        mockMvc.perform(delete("/api/car/delete/{id}", carId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.name").value("Honda"));
    }

}
