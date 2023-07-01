package com.example.demo.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.example.demo.Entity.Cart_Item;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.HoaReponsitory;
import com.example.demo.repository.UserRepository;

@Service
public class CartServices {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HoaReponsitory hoaReponsitory;

    public CartServices(CartRepository cartRepository, UserRepository userRepository, HoaReponsitory hoaReponsitory) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
        this.hoaReponsitory = hoaReponsitory;
    }

    public void addtocart(Long productID, Long userID, int soluong) {
        Optional<Cart_Item> existingCart = cartRepository.findByUser_idAndHoa_id(userID, productID);
        if (existingCart.isPresent()) {
            Cart_Item cart_Item = existingCart.get();
            cart_Item.setSoluong(cart_Item.getSoluong() + soluong);
            cartRepository.save(cart_Item);

        } else {
            Cart_Item cart_Item = new Cart_Item();
            cart_Item.setUser(userRepository.findById(userID).get());
            cart_Item.setHoa(hoaReponsitory.findById(productID).get());
            cart_Item.setSoluong(soluong);
            cartRepository.save(cart_Item);

        }
    }
}
