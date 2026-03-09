//package com.example.demo.Controller;
//
//import com.example.demo.Entity.Shoes;
//import com.example.demo.Service.ShoesService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//public class ShoesController {
//    @Autowired
//    private ShoesService shoesService;
//
//    @GetMapping("/shoes")
//    public List<Shoes> getAllShoes(){
//        return shoesService.getAllShoes();
//    }
//
//    @GetMapping("/shoes/{id}")
//    public Shoes getShoesById(@PathVariable Long id){
//        return shoesService.getShoesById(id);
//    }
//
//    @PostMapping("/shoes/add")
//    public Shoes addShoes(@RequestBody Shoes shoes){
//        return shoesService.addShoes(shoes);
//    }
//
//    @DeleteMapping("/shoes/{id}")
//    public void deleteShoes(@PathVariable Long id){
//        shoesService.deleteShoes(id);
//    }
//
//    @PutMapping("/shoes/{id}")
//    public Shoes updateShoes(@PathVariable Long id, @RequestBody Shoes shoes){
//       return shoesService.updateShoes(id, shoes);
//    }
//}
