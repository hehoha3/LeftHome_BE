package com.example.firstWebBE.repository;

import com.example.firstWebBE.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findAllById(Long id);
}
