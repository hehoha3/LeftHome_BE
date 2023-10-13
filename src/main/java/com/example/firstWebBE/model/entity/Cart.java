package com.example.firstWebBE.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Table(name = "cart")
@NoArgsConstructor
@Setter
@Getter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_date")
    @CreationTimestamp
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private User user;

    private Long quantity;

    public Cart(Product product, User user, Long quantity) {
        this.product = product;
        this.user = user;
        this.quantity = this.product.getQuantity();
        createdDate = new Date();
    }
}
