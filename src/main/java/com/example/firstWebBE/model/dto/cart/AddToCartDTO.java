package com.example.firstWebBE.model.dto.cart;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddToCartDTO {
    private Long id;

    private @NotNull Long product_id;

//    private @NotNull Long quantity;
}
