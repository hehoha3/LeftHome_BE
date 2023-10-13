package com.example.firstWebBE.service;

import com.example.firstWebBE.model.entity.Category;
import com.example.firstWebBE.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    @Autowired
    private final CategoryRepository categoryRepository;

    public List<Category> getListCategory(){return categoryRepository.findAll();}

    public Category getCategoryById(Long id){return categoryRepository.findAllById(id);}
}
