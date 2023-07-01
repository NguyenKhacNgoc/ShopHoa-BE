package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.UserRequest;
import com.example.demo.Entity.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRequest request) {
        if (userRepository.findByEmail(request.getEmail()) == null) {
            User user = new User();
            user.setUsername(request.getUsername());
            user.setEmail(request.getEmail());
            user.setPassword(request.getPassword());
            userRepository.save(user);

            return ResponseEntity.ok("Đăng kí thành công");

        } else {
            return ResponseEntity.badRequest().body("Người dùng đã tồn tại");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserRequest request) {
        if (userRepository.findByEmail(request.getEmail()) == null) {
            return ResponseEntity.badRequest().body("Tài khoản không tồn tại");
        } else {
            if (request.getPassword().equals(userRepository.findByEmail(request.getEmail()).getPassword()) == true) {
                return ResponseEntity.ok(userRepository.findByEmail(request.getEmail()));

            } else {
                return ResponseEntity.badRequest().body("Sai mật khẩu");
            }
        }

    }

}
