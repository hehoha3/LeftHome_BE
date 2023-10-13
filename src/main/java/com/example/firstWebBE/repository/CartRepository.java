package com.example.firstWebBE.repository;

import com.example.firstWebBE.model.entity.Cart;
import com.example.firstWebBE.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findAllByUserOrderByCreatedDateDesc(User user);

    void deleteByUser(User user);

    boolean existsByUser(User user);
}
