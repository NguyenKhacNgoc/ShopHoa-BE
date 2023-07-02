package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Hoa;
import com.example.demo.repository.HoaRepository;

@Service
public class HoaServices {
    @Autowired
    private HoaRepository hoaRepository;

    public List<Hoa> getAllHoa() {
        return hoaRepository.findAll();
    }

    public List<Hoa> getHoaByCategory(String category) {
        return hoaRepository.findByCategory(category);
    }

}
