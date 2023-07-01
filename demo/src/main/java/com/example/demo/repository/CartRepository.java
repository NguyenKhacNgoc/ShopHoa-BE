package com.example.demo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entity.Cart_Item;
import com.example.demo.Entity.User;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart_Item, Long> {
    Optional<Cart_Item> findByUser_idAndHoa_id(Long user_id, Long hoa_id);

    List<Cart_Item> findByUser(User userid);

}
