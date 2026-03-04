package com.example.demo.Service;

import com.example.demo.Entity.Shoes;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoesService {
    private List<Shoes> shoess = new ArrayList<>();

    //取得所有
    public List<Shoes> getAllShoes() {
        return shoess;
    }
    //使用ID取得
    public Shoes getShoesById(Long id) {
        for (int i = 0; i < shoess.size(); i++) {
            Shoes currentShoes = shoess.get(i);
            if (currentShoes.getId().equals(id)) {
                return currentShoes;
            }
        }
        return null;
    }

    //新增
    public Shoes addShoes(Shoes shoes) {
        shoess.add(shoes);
        return shoes;
    }
    //刪除
    public Shoes deleteShoes(Long id) {
        for (int i = 0; i < shoess.size(); i++) {
            Shoes delShoes = shoess.get(i);
            if (delShoes.getId().equals(id)) {
                return shoess.remove(i);
            }

        }
        return null;
    }

    //修改
    public Shoes updateShoes(Long id, Shoes shoes){
        for(int i = 0; i < shoess.size(); i++){
            Shoes updShoes = shoess.get(i);
            if(updShoes.getId().equals(id)){
                updShoes.setName(shoes.getName());
                updShoes.setShoeSize(shoes.getShoeSize());
                updShoes.setStyle(shoes.getStyle());
                return updShoes;
            }
        }
        return null;
    }
}
