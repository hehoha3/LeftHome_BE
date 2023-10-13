package com.example.firstWebBE.service;

import com.example.firstWebBE.config.exceptionHandler.CustomException;
import com.example.firstWebBE.model.dto.cart.AddToCartDTO;
import com.example.firstWebBE.model.dto.cart.CartDTO;
import com.example.firstWebBE.model.dto.cart.CartItemDto;
import com.example.firstWebBE.model.entity.Cart;
import com.example.firstWebBE.model.entity.Product;
import com.example.firstWebBE.model.entity.User;
import com.example.firstWebBE.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {
    @Autowired
    private final CartRepository cartRepository;

    @Autowired
    private final ProductService productService;

//    ADD
    public void addToCart(AddToCartDTO addToCartDto, Product product, User user){
        Cart cart = new Cart(product, user, product.getQuantity());
        cartRepository.save(cart);
    }

//    GET
    public CartDTO listCartItems(User user) {
        List<Cart> cartList = cartRepository.findAllByUserOrderByCreatedDateDesc(user);

        List<CartItemDto> cartItems = new ArrayList<>();

        double totalPrice = 0;
        Long cartNumb = 0L;

        for (Cart cart: cartList){
            CartItemDto cartItemDto = new CartItemDto(cart);
            cartNumb += cartItemDto.getQuantity();
            totalPrice += cartItemDto.getQuantity() * cart.getProduct().getPrice();
            cartItems.add(cartItemDto);
        }
        CartDTO cartDTO = new CartDTO();
        cartDTO.setTotalPrice(totalPrice);
        cartDTO.setCartItems(cartItems);
        return cartDTO;
    }

//    DELETE
//    public void deleteCartItem(Long cartItemId, User user) {
//        Optional<Cart> optionalCart = cartRepository.findById(cartItemId);
//
//        if (optionalCart.isEmpty()){
//            throw new CustomException("Cart Item Is Not Exist !!");
//        }
//
//        Cart cart = optionalCart.get();
//
//        if (cart.getUser() != user){
//            throw new CustomException("Cart Item Is Not Belong To User !!");
//        }
//
//        cartRepository.delete(cart);
//    }

    public void deleteCartItem(Long id) throws CustomException {
        if (!cartRepository.existsById(id)){
            throw new CustomException("Cart Item Is Not Exist !");
        }
        cartRepository.deleteById(id);
    }

    public void deleteAllCartItem(User user) {
        List<Cart> cartList = cartRepository.findAllByUserOrderByCreatedDateDesc(user);

    }
}
