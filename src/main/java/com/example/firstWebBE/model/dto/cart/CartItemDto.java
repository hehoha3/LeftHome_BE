package com.example.firstWebBE.model.dto.cart;

import com.example.firstWebBE.model.entity.Cart;
import com.example.firstWebBE.model.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CartItemDto {
    private Long id;
    private Long quantity;
    private Product product;

    public CartItemDto(Cart cart) {
        this.id = cart.getId();
        this.quantity = cart.getQuantity();
        this.setProduct(cart.getProduct());
    }
}
