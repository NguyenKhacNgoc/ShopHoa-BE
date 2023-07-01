package com.example.demo.controller;

import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Hoa;
import com.example.demo.repository.HoaReponsitory;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private HoaReponsitory hoaReponsitory;

    public ProductController(HoaReponsitory hoaReponsitory) {
        this.hoaReponsitory = hoaReponsitory;

    }

    @GetMapping("/{category}")
    public List<Hoa> getProductByCategory(@PathVariable String category, @RequestParam int sorted) {
        List<Hoa> sortedProducts;
        if (sorted == 1) {
            sortedProducts = hoaReponsitory.findByCategory(category);
            sortedProducts.sort(Comparator.comparing(Hoa::getGiaban).reversed());
            return sortedProducts;
        }
        if (sorted == 2) {
            sortedProducts = hoaReponsitory.findByCategory(category);
            return sortedProducts;
        }
        if (sorted == 3) {
            sortedProducts = hoaReponsitory.findByCategory(category);
            sortedProducts.sort(Comparator.comparing(Hoa::getGiaban));
            return sortedProducts;
        } else {
            sortedProducts = hoaReponsitory.findByCategory(category);
            return sortedProducts;
        }

    }

}
