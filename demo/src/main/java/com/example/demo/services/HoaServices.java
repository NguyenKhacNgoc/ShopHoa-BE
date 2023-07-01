package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Hoa;
import com.example.demo.repository.HoaReponsitory;

@Service
public class HoaServices {
    @Autowired
    private HoaReponsitory hoaReponsitory;
    public List<Hoa> getAllHoa(){
        return hoaReponsitory.findAll();
    }
    public List<Hoa> getHoaByCategory(String category){
        return hoaReponsitory.findByCategory(category);
    }

  
}
