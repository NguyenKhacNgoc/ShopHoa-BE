package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Entity.Hoa;

import com.example.demo.repository.HoaReponsitory;

@RestController
@RequestMapping("/api")
public class TestAPI {
    @Autowired
    private HoaReponsitory hoaReponsitory;

    public TestAPI(HoaReponsitory hoaReponsitory) {
        this.hoaReponsitory = hoaReponsitory;

    }

    @GetMapping("/productdetail/{productID}")
    public Hoa detail(@PathVariable Long productID) {
        return hoaReponsitory.findById(productID).get();
    }

    @GetMapping("/getcategory")
    public List<String> getallCategories() {

        return hoaReponsitory.findDistinctCategoryBy();

    }

    @PostMapping(value = "/admin/addproduct", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> addProduct(
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("price") double price,
            @RequestParam("category") String category,
            @RequestParam("images") MultipartFile images) {
        Hoa hoa = new Hoa();
        hoa.setTenhoa(name);
        hoa.setMota(description);
        hoa.setGiaban(price);
        String fileName = images.getOriginalFilename();
        String filePath = "D:\\SHOPHOATUOI\\SpringBoot\\demo\\src\\main\\resources\\static\\uploads\\" + fileName;
        try {
            File dest = new File(filePath);
            images.transferTo(dest);
            hoa.setHinhanh("http://localhost:8080/uploads/" + fileName);

        } catch (IOException e) {
            return ResponseEntity.badRequest().body("Lỗi khi lưu file hình ảnh");

        }
        hoa.setCategory(category);
        // Lưu vào database
        hoaReponsitory.save(hoa);
        return ResponseEntity.ok("Thêm thành công");

    }

}
