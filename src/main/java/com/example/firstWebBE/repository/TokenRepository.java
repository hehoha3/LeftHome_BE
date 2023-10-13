package com.example.firstWebBE.repository;

import com.example.firstWebBE.model.entity.AuthenticationToken;
import com.example.firstWebBE.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<AuthenticationToken, Long> {
    AuthenticationToken findByUser(User user);

    AuthenticationToken findByToken(String token);
}
