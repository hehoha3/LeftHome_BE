package com.example.firstWebBE.service;

import com.example.firstWebBE.config.exceptionHandler.ProductNotExistsException;
import com.example.firstWebBE.model.dto.ProductDTO;
import com.example.firstWebBE.model.entity.Product;
import com.example.firstWebBE.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProduct(){
        return productRepository.findAll();
    }

    public Product getProductById(Long productId) throws ProductNotExistsException {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (!optionalProduct.isPresent())
            throw new ProductNotExistsException("Product id: " + productId + " is invalid !");
        return optionalProduct.get();
    }


    public Product addProduct(ProductDTO productRequest){
        Product product = Product.build(0L,
                productRequest.getThumbnail(),
                productRequest.getName(),
                productRequest.getDescription(),
                productRequest.getMaterial(),
                productRequest.getPrice(),
                productRequest.getQuantity(),
                productRequest.getSizes(),
                productRequest.getId_type());
        return productRepository.save(product);
    }

    public String updateProduct(Long id, ProductDTO productRequest){
        if (productRepository.existsById(id)){
            Product product = productRepository.findAllById(id);
            product.setThumbnail(productRequest.getThumbnail());
            product.setName(productRequest.getName());
            product.setDescription(productRequest.getDescription());
            product.setMaterial(productRequest.getMaterial());
            product.setPrice(productRequest.getPrice());
            product.setQuantity(productRequest.getQuantity());
            product.setSizes(productRequest.getSizes());
            product.setId_type(productRequest.getId_type());
            productRepository.save(product);
            return "UPDATE PRODUCT SUCCESSFULLY";
        } else {
            return "ID DOES NOT EXIST !!!";
        }
    }

    public String deleteProduct(Long id){
        if (productRepository.existsById(id)){
            productRepository.deleteById(id);
            return "DELETE PRODUCT SUCCESSFULLY";
        } else {
            return "ID DOES NOT EXIST !!!";
        }
    }

//    public Product getProductToCart(Long id) throws ProductNotExistsException {
//        Optional<Product> optionalProduct = productRepository.findById(id);
//        if (!optionalProduct.isPresent()) {
//            throw new ProductNotExistsException("Product is Not Exist");
//        }
//        return optionalProduct.get();
//    }
}
