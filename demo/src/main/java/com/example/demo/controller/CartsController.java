package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.CartRequest;
import com.example.demo.Entity.Cart_Item;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.HoaRepository;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class CartsController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HoaRepository hoaRepository;
    @Autowired
    private CartRepository cartRepository;

    public CartsController(UserRepository userRepository, HoaRepository hoaRepository,
            CartRepository cartRepository) {
        this.userRepository = userRepository;
        this.hoaRepository = hoaRepository;
        this.cartRepository = cartRepository;
    }

    @PostMapping("/addtocart")
    public ResponseEntity<?> addtoCart(@RequestBody CartRequest cartRequest) {
        Optional<Cart_Item> existingCart = cartRepository.findByUser_idAndHoa_id(cartRequest.getUserID(),
                cartRequest.getProductID());
        if (existingCart.isPresent()) {
            Cart_Item cart_Item = existingCart.get();
            cart_Item.setSoluong(cart_Item.getSoluong() + cartRequest.getQuantity());
            cartRepository.save(cart_Item);
            return ResponseEntity.ok("Đã cập nhật sản phẩm vào giỏ hàng");

        } else {
            Cart_Item cart_Item = new Cart_Item();
            cart_Item.setUser(userRepository.findById(cartRequest.getUserID()).get());
            cart_Item.setHoa(hoaRepository.findById(cartRequest.getProductID()).get());

            cart_Item.setSoluong(cartRequest.getQuantity());

            cartRepository.save(cart_Item);
            return ResponseEntity.ok("Đã thêm sản phẩm vào giỏ hàng");

        }
    }

    @GetMapping("/carts")
    public List<Cart_Item> getCarts(@RequestParam("userid") Long userID) {

        List<Cart_Item> cart_Items = cartRepository.findByUser(userRepository.findById(userID).get());
        return cart_Items;
    }

    @PutMapping("/updatecart")
    public ResponseEntity<?> updateQuantity(@RequestBody CartRequest request) {
        Optional<Cart_Item> existingCart = cartRepository.findById(request.getCartID());
        if (existingCart.isPresent()) {
            Cart_Item cart_Item = existingCart.get();
            cart_Item.setSoluong(request.getQuantity());
            cartRepository.save(cart_Item);
            return ResponseEntity.ok("Updated");
        } else {
            return ResponseEntity.badRequest().body("Sản phẩm không tồn tại trong giỏ hàng");
        }
    }

    @DeleteMapping("/deletecart")
    public ResponseEntity<?> deleteCart(@RequestParam("cartid") Long cartID) {
        Optional<Cart_Item> existingCart = cartRepository.findById(cartID);
        if (existingCart.isPresent()) {
            cartRepository.deleteById(cartID);
            return ResponseEntity.ok("Deleted");
        }

        else {
            return ResponseEntity.badRequest().body("Sản phẩm không tồn tại");
        }
    }
}
