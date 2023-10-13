package com.example.firstWebBE.model.dto;

import com.example.firstWebBE.model.entity.Category;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class ProductDTO {
    private Long id;

    @NotNull(message = "Thumbnail Shouldn't Be NULL")
    @NotEmpty(message = "Thumbnail Shouldn't Be Empty")
    private String thumbnail;

    @NotNull(message = "Thumbnail Shouldn't Be NULL")
    @NotEmpty(message = "Thumbnail Shouldn't Be Empty")
    private String name;

    @NotNull(message = "Description Shouldn't Be NULL")
    @NotEmpty(message = "Description Shouldn't Be Empty")
    private String description;

    @NotNull(message = "Material Shouldn't Be NULL")
    @NotEmpty(message = "Material Shouldn't Be Empty")
    private String material;

    @NotNull(message = "Price Shouldn't Be NULL")
    private Double price;

    @NotNull(message = "Quantity of Product Shouldn't Be NULL")
    private Long quantity;

    @NotNull(message = "Sizes Shouldn't Be NULL")
    @NotEmpty(message = "Sizes Shouldn't Be Empty")
    private String sizes;

    @NotNull(message = "Type of Product Shouldn't Be NULL")
    private Long id_type;
}
