package com.example.firstWebBE.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Table(name = "Product")
@Getter
@Setter
@ToString
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class Product {
    @Id
    @SequenceGenerator(
            name = "sequence_product",
            allocationSize = 1,
            sequenceName = "sequence_product"
    )
    @GeneratedValue(
            generator = "sequence_product",
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(name = "thumbnail")
    private String thumbnail;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "material")
    private String material;
    @Column(name = "price")
    private Double price;
    @Column(name = "quantity")
    private Long quantity;
    @Column(name = "sizes")
    private String sizes;

    @Column(name = "id_type")
    private Long id_type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Product product = (Product) o;
        return getId() != null && Objects.equals(getId(), product.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
