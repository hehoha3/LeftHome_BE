package com.example.firstWebBE.controller;

import com.example.firstWebBE.config.exceptionHandler.ProductNotExistsException;
import com.example.firstWebBE.model.dto.ProductDTO;
import com.example.firstWebBE.model.entity.Category;
import com.example.firstWebBE.model.entity.Product;
import com.example.firstWebBE.service.CategoryService;
import com.example.firstWebBE.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/product")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
    @Autowired
    private final ProductService productService;

    @Autowired
    private final CategoryService categoryService;

    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProduct(){
        List<Product> list = productService.getProduct();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) throws ProductNotExistsException {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody @Valid ProductDTO productRequest){
        return new ResponseEntity<>(productService.addProduct(productRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(
            @PathVariable Long id,
            @RequestBody @Valid ProductDTO productRequest){
        return new ResponseEntity<>(productService.updateProduct(id, productRequest), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
    }

//    CATEGORY
    @GetMapping("/cg")
    public ResponseEntity<List<Category>> getListCategory(){
        return new ResponseEntity<>(categoryService.getListCategory(), HttpStatus.OK);
    }

    @GetMapping("/cg/{idType}")
    public ResponseEntity<List<Category>> getListProductByCategory(){
        return new ResponseEntity<>(categoryService.getListCategory(), HttpStatus.OK);
    }
}
