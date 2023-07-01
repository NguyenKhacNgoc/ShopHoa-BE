package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.Entity.Admin;
import com.example.demo.Entity.Hoa;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.HoaReponsitory;
import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private HoaReponsitory hoaReponsitory;

    public AdminController(AdminRepository adminRepository, HoaReponsitory hoaReponsitory) {
        this.adminRepository = adminRepository;
        this.hoaReponsitory = hoaReponsitory;

    }

    @PostMapping("/auth/admin/register")
    public String registerAdmin(@ModelAttribute Admin admin) {
        if (adminRepository.findByUsername(admin.getUsername()) == null) {
            adminRepository.save(admin);
        }
        return "redirect:/";
    }

    @PostMapping("/auth/admin/login")
    public String loginAdmin(@ModelAttribute Admin admin, HttpSession session, Model model) {
        Admin existingAdmin = adminRepository.findByUsername(admin.getUsername());
        if (existingAdmin != null && existingAdmin.getPassword().equals(admin.getPassword())) {
            session.setAttribute("loggedInAdmin", existingAdmin);

        }
        return "redirect:/";
    }

    @GetMapping("/add")
    public String showaddproduct() {
        return "addProducts";
    }

    @PostMapping("/admin/add")
    public String addProducts(@RequestParam("name-product") String name,
            @RequestParam String description, @RequestParam double price,
            @ModelAttribute String category, @RequestParam MultipartFile images) {

        Hoa hoa = new Hoa();
        hoa.setTenhoa(name);
        hoa.setMota(description);
        hoa.setGiaban(price);
        String fileName = images.getOriginalFilename();
        String filePath = "D:/SpringBoot/ngoc/demo/src/main/resources/static/uploads/" + fileName;
        try {
            File dest = new File(filePath);
            images.transferTo(dest);
            hoa.setHinhanh("http://localhost:8080/uploads/" + fileName);

        } catch (IOException e) {
            e.printStackTrace();

        }
        hoa.setCategory(category);
        // Lưu vào database
        hoaReponsitory.save(hoa);

        return "redirect:/index";

    }

}
